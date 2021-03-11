package br.com.reactivebank.service.impl;

import br.com.reactivebank.domain.OperationType;
import br.com.reactivebank.domain.Transaction;
import br.com.reactivebank.dto.TransactionDTO;
import br.com.reactivebank.enums.OperationTypeEnum;
import br.com.reactivebank.exception.OperationTypeNotFoundError;
import br.com.reactivebank.repository.OperationTypeRepository;
import br.com.reactivebank.repository.TransactionRepository;
import br.com.reactivebank.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
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
    private final OperationTypeRepository operationTypeRepository;

    @Override
    public Mono<Transaction> save(TransactionDTO transactionDTO) throws OperationTypeNotFoundError {
        ModelMapper modelMapper = new ModelMapper();
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
        transaction.setEventDate(LocalDateTime.now());
        transaction.setId(null);
        validateNegativeValueInWithdrawalOrPurchase(transaction);
        validatePositivePayment(transaction);
        log.info("[TransactionServiceImpl - save] - Saving Transaction object: " + transaction);

        return repository.save(transaction);
    }

    private void validateNegativeValueInWithdrawalOrPurchase(Transaction transaction) {

        if(ObjectUtils.allNotNull(transaction, transaction.getOperationTypeId(), transaction.getAmount())) {
            Long operation = transaction.getOperationTypeId();

            List<Long> negativeOperationsId = List.of(OperationTypeEnum.COMPRA_A_VISTA.getId(),
                    OperationTypeEnum.COMPRA_PARCELADA.getId(),
                    OperationTypeEnum.SAQUE.getId());

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
