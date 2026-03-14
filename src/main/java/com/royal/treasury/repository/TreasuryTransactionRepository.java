package com.royal.treasury.repository;

import com.royal.treasury.domain.TreasuryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreasuryTransactionRepository extends JpaRepository<TreasuryTransaction, Long> {

    List<TreasuryTransaction> findByAccountId(Long accountId);

}