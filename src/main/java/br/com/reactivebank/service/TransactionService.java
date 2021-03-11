package br.com.reactivebank.service;

import br.com.reactivebank.domain.Transaction;
import br.com.reactivebank.dto.TransactionDTO;
import reactor.core.publisher.Mono;

/**
 * Interface responsible in centralize all logical business of Transaction.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 09/03/21
 */
public interface TransactionService {

    /**
     * Save an Account.
     *
     * @param transactionDTO
     * @return Transaction
     */
    Mono<Transaction> save(final TransactionDTO transactionDTO);
}
