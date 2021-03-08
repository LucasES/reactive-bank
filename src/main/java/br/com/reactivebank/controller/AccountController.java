package br.com.reactivebank.controller;

import br.com.reactivebank.domain.Account;
import br.com.reactivebank.dto.AccountDTO;
import br.com.reactivebank.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * REST API controller for Account.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 06/03/21
 */
@RestController
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("accounts")
    public Mono<Account> save(@RequestBody Mono<AccountDTO> account){
        System.out.println("awe");
        return account.flatMap(this.service::save);
    }

    @GetMapping("accounts/{accountId}")
    public Mono<ResponseEntity<Account>> getProductById(@PathVariable Long accountId){
        return this.service.findById(accountId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
