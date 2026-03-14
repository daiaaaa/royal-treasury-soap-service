package com.royal.treasury.repository;

import com.royal.treasury.domain.NobleAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NobleAccountRepository extends JpaRepository<NobleAccount, Long> {

}