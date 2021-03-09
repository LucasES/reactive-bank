package br.com.reactivebank.service.impl;

import br.com.reactivebank.domain.Transaction;
import br.com.reactivebank.dto.TransactionDTO;
import br.com.reactivebank.repository.TransactionRepository;
import br.com.reactivebank.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Business logic implementation of Transaction.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 09/03/21
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Transaction> save(TransactionDTO transactionDTO) {
        Transaction map = mapper.map(transactionDTO, Transaction.class);
//        return repository.save(map);
        System.out.println(map);
        return null;
    }
}
