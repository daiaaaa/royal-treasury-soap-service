package com.royal.treasury.service;

import com.royal.treasury.domain.TreasuryTransaction;
import com.royal.treasury.domain.TransactionType;
import com.royal.treasury.repository.TreasuryTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TreasuryTransactionRepository transactionRepository;
    private final AccountService accountService;

    @Transactional
    public void deposit(Long accountId, BigDecimal amount) {

        validateAmount(amount);

        TreasuryTransaction transaction = TreasuryTransaction.builder()
                .accountId(accountId)
                .type(TransactionType.DEPOSIT)
                .amount(amount)
                .createdAt(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);
    }

    @Transactional
    public void payment(Long accountId, BigDecimal amount) {

        validateAmount(amount);

        BigDecimal balance = accountService.getBalance(accountId);

        if (balance.compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        TreasuryTransaction transaction = TreasuryTransaction.builder()
                .accountId(accountId)
                .type(TransactionType.PAYMENT)
                .amount(amount)
                .createdAt(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Invalid amount");
        }
    }
}