package br.com.reactivebank.service.impl;

import br.com.reactivebank.domain.Transaction;
import br.com.reactivebank.dto.TransactionDTO;
import br.com.reactivebank.repository.AccountRepository;
import br.com.reactivebank.repository.OperationTypeRepository;
import br.com.reactivebank.repository.TransactionRepository;
import br.com.reactivebank.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

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

    private final OperationTypeRepository operationTypeRepository;

    @Override
    public Mono<Transaction> save(TransactionDTO transactionDTO) {

        ModelMapper modelMapper = new ModelMapper();
        Transaction map = modelMapper.map(transactionDTO, Transaction.class);
        map.setEventDate(LocalDateTime.now());
        map.setId(null);

        log.info("[TransactionServiceImpl - save] - Saving Transaction object: " + map);

        return repository.save(map);
    }
}
