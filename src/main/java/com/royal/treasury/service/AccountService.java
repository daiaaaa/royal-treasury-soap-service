package com.royal.treasury.service;

import com.royal.treasury.domain.NobleAccount;
import com.royal.treasury.domain.TransactionType;
import com.royal.treasury.repository.NobleAccountRepository;
import com.royal.treasury.repository.TreasuryTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final NobleAccountRepository accountRepository;
    private final TreasuryTransactionRepository transactionRepository;

    public NobleAccount createAccount(String nobleName, String kingdom) {

        NobleAccount account = NobleAccount.builder()
                .nobleName(nobleName)
                .kingdom(kingdom)
                .createdAt(java.time.LocalDateTime.now())
                .build();

        return accountRepository.save(account);
    }

    public NobleAccount getAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public BigDecimal getBalance(Long accountId) {

        var transactions = transactionRepository.findByAccountId(accountId);

        BigDecimal balance = BigDecimal.ZERO;

        for (var transaction : transactions) {
            if (transaction.getType() == TransactionType.DEPOSIT) {
                balance = balance.add(transaction.getAmount());
            } else {
                balance = balance.subtract(transaction.getAmount());
            }
        }

        return balance;
    }
}