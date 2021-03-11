package br.com.reactivebank.controller;

import br.com.reactivebank.domain.Transaction;
import br.com.reactivebank.dto.TransactionDTO;
import br.com.reactivebank.exception.OperationTypeNotFoundError;
import br.com.reactivebank.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * REST API controller for Transaction.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 06/03/21
 */
@RestController
@Log4j2
@AllArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @Operation(summary = "Save a new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The account by id"),
            @ApiResponse(responseCode = "500", description = "An exception was thrown"),
    })
    @PostMapping("transactions")
    public Mono<Transaction> save(@RequestBody TransactionDTO transaction) {
        log.info("[TransactionController - save] - Starting with Transaction: " + transaction);

        Mono<Transaction> transactionMono = this.service.save(transaction);

        log.info("[TransactionController - save] - Ending with saved Transaction: " + transactionMono);

        return transactionMono;
    }
}
