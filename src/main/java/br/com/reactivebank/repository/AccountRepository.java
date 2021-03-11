package br.com.reactivebank.repository;

import br.com.reactivebank.domain.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Reactive CRUD repository for Account.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 06/03/21
 */
@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, Long> {
}
