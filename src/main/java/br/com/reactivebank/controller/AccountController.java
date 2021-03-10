package br.com.reactivebank.controller;

import br.com.reactivebank.domain.Account;
import br.com.reactivebank.dto.AccountDTO;
import br.com.reactivebank.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * REST API controller for Account.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 06/03/21
 */
@RestController
@Log4j2
@AllArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping("accounts")
    public Mono<Account> save(@Valid @RequestBody AccountDTO account){
        log.info("[AccountController - save] - Starting with AccountDTO: " + account);

        Mono<Account> accountMono = this.service.save(account);

        log.info("[AccountController - save] - Starting with Account: " + accountMono);

        return accountMono;
    }

    @GetMapping("accounts/{accountId}")
    public Mono<ResponseEntity<Account>> getProductById(@PathVariable Long accountId){
        log.info("[AccountController - getProductById] - Starting with accountId: " + accountId);

        Mono<ResponseEntity<Account>> responseEntityMono = this.service.findById(accountId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());

        log.info("[AccountController - getProductById] - Ending with responseEntityMono: " + responseEntityMono);

        return responseEntityMono;
    }
}
