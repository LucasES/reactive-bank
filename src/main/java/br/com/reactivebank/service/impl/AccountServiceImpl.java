package br.com.reactivebank.service.impl;

import br.com.reactivebank.domain.Account;
import br.com.reactivebank.dto.AccountDTO;
import br.com.reactivebank.repository.AccountRepository;
import br.com.reactivebank.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Business logic implementation of Account.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 06/03/21
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Account> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Account> save(AccountDTO account) {
        Account map = mapper.map(account, Account.class);
        return repository.save(map);
    }
}
