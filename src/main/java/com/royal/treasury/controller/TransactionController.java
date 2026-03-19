package com.royal.treasury.controller;

import com.royal.treasury.dto.TransactionRequest;
import com.royal.treasury.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/deposit")
    public void deposit(@RequestBody TransactionRequest request) {
        transactionService.deposit(
                request.getAccountId(),
                request.getAmount()
        );
    }

    @PostMapping("/payment")
    public void payment(@RequestBody TransactionRequest request) {
        transactionService.payment(
                request.getAccountId(),
                request.getAmount()
        );
    }
}