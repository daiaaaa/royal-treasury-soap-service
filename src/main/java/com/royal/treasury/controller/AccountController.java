package com.royal.treasury.controller;

import com.royal.treasury.domain.NobleAccount;
import com.royal.treasury.dto.CreateAccountRequest;
import com.royal.treasury.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public NobleAccount createAccount(@RequestBody CreateAccountRequest request) {
        return accountService.createAccount(
                request.getNobleName(),
                request.getKingdom()
        );
    }

    @GetMapping("/{id}")
    public NobleAccount getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @GetMapping("/{id}/balance")
    public BigDecimal getBalance(@PathVariable Long id) {
        return accountService.getBalance(id);
    }
}