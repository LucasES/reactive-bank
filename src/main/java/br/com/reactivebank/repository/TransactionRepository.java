package br.com.reactivebank.repository;

import br.com.reactivebank.domain.Account;
import br.com.reactivebank.domain.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Reactive CRUD repository for Account.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 09/03/21
 */
@Repository
public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Long> {
}
