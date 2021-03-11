package br.com.reactivebank.service.impl;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.reactivebank.domain.Account;
import br.com.reactivebank.dto.AccountDTO;
import br.com.reactivebank.enums.ReactiveBankException;
import br.com.reactivebank.repository.AccountRepository;
import br.com.reactivebank.service.AccountService;
import br.com.reactivebank.util.ReactiveBankUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.List;

/**
 * Business logic implementation of Account.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 06/03/21
 */
@Service
@Log4j2
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
        if(!ReactiveBankUtil.isValid(account.getDocumentNumber())) {
            ReactiveBankUtil.generateMonoError(ReactiveBankException
                            .DOCUMENT_NUMBER_INCORRECT.getDescription()).block();
        }

        Account map = mapper.map(account, Account.class);
        return repository.save(map);
    }


}
