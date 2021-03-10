package br.com.reactivebank.controller;

import br.com.reactivebank.domain.Transaction;
import br.com.reactivebank.dto.TransactionDTO;
import br.com.reactivebank.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * REST API controller for Transaction.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 06/03/21
 */
@RestController
@Log4j2
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("transactions")
    public Mono<Transaction> save(@Valid @RequestBody TransactionDTO transaction){
        log.info("[TransactionController - save] - Starting with Transaction: " + transaction);

        Mono<Transaction> transactionMono = this.service.save(transaction);

        log.info("[TransactionController - save] - Ending with saved Transaction: " + transactionMono);

        return transactionMono;
    }
}
