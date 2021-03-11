package br.com.reactivebank.service;

import br.com.reactivebank.domain.Account;
import br.com.reactivebank.dto.AccountDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface responsible in centralize all logical business of Account.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 06/03/21
 */
public interface AccountService {

    /**
     * Find an account by ID;
     *
     * @param id
     * @return Account
     */
    Mono<Account> findById(Long id);

    /**
     * Save an Account.
     *
     * @param account
     * @return Account
     */
    Mono<Account> save(final AccountDTO account);
}
