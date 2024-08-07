package com.obagajesse.BankingSystemAPI.Repository;

import com.obagajesse.BankingSystemAPI.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
