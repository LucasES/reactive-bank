package br.com.reactivebank.service.impl;

import br.com.reactivebank.domain.Account;
import br.com.reactivebank.domain.Transaction;
import br.com.reactivebank.dto.AccountDTO;
import br.com.reactivebank.dto.TransactionDTO;
import br.com.reactivebank.enums.OperationTypeEnum;
import br.com.reactivebank.enums.ReactiveBankException;
import br.com.reactivebank.exception.OperationTypeNotFoundError;
import br.com.reactivebank.repository.AccountRepository;
import br.com.reactivebank.repository.TransactionRepository;
import br.com.reactivebank.service.TransactionService;
import br.com.reactivebank.util.ReactiveBankUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Business logic implementation of Transaction.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 09/03/21
 */
@Service
@AllArgsConstructor
@Log4j2
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    private final AccountRepository accountRepository;

    @Override
    public Mono<Transaction> save(TransactionDTO transactionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
        transaction.setEventDate(LocalDateTime.now());
        transaction.setId(null);
        validateNegativeValueInWithdrawalOrPurchase(transaction);
        validatePositivePayment(transaction);

        log.info("[TransactionServiceImpl - save] - Saving Transaction object: " + transaction);

        Mono<Account> byId = accountRepository.findById(transaction.getAccountId());

        return byId.flatMap((c) -> validateCreditLimit(c, transactionDTO.getAmount(), transactionDTO.getOperationTypeId()))
                .flatMap((account) -> repository.save(transaction)
                        .flatMap((t) -> updateAvailableCredit(account, transactionDTO.getAmount(), transactionDTO.getOperationTypeId())
                                .map((c)-> t)));
    }

    private Mono<Account> validateCreditLimit(Account accountMono, BigDecimal amount, Long operationId) {
        BigDecimal availableLimitCredit = accountMono.getAvailableLimitCredit();
        List<Long> negativeOperations = getNegativeOperations();

        boolean isNegativeOperation = negativeOperations.stream().anyMatch(negative -> negative.equals(operationId));

        BigDecimal subtract = availableLimitCredit.subtract(amount);
        if(isNegativeOperation && subtract.compareTo(BigDecimal.ZERO) < 0) {
            return ReactiveBankUtil.generateMonoError(ReactiveBankException
                    .INSUFICIENT_LIMIT.getDescription());
        }

        return Mono.just(accountMono);
    }

    private Mono<Account> updateAvailableCredit(Account account, BigDecimal amount, Long operationId) {

        List<Long> negativeOperationsId = getNegativeOperations();

        if(negativeOperationsId.stream().anyMatch(neg -> neg.equals(operationId))) {
            account.setAvailableLimitCredit(account.getAvailableLimitCredit().subtract(amount));
        } else if(OperationTypeEnum.PAGAMENTO.getId().equals(operationId)) {
            account.setAvailableLimitCredit(account.getAvailableLimitCredit().add(amount));
        }

        return accountRepository.save(account);
    }

    private List<Long> getNegativeOperations() {
        return List.of(OperationTypeEnum.COMPRA_A_VISTA.getId(),
                OperationTypeEnum.COMPRA_PARCELADA.getId(),
                OperationTypeEnum.SAQUE.getId());
    }

    private void validateNegativeValueInWithdrawalOrPurchase(Transaction transaction) {

        if(ObjectUtils.allNotNull(transaction, transaction.getOperationTypeId(), transaction.getAmount())) {
            Long operation = transaction.getOperationTypeId();

            List<Long> negativeOperationsId = getNegativeOperations();

            boolean isWithdrawalOrPurchaseOperation = negativeOperationsId.stream().anyMatch(id -> id.equals(operation));

            BigDecimal amount = transaction.getAmount();
            if(isWithdrawalOrPurchaseOperation && amount.signum() > 0) {
                transaction.setAmount(transaction.getAmount().negate());
            }
        }
    }

    private void validatePositivePayment(Transaction transaction) {

        if(ObjectUtils.allNotNull(transaction, transaction.getOperationTypeId(), transaction.getAmount())) {
            Long operation = transaction.getOperationTypeId();

            BigDecimal amount = transaction.getAmount();
            if(OperationTypeEnum.PAGAMENTO.getId().equals(operation) && amount.signum() < 0) {
                transaction.setAmount(transaction.getAmount().abs());
            }
        }
    }

}
