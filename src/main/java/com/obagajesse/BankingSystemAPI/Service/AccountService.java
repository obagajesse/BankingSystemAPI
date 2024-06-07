package com.obagajesse.BankingSystemAPI.Service;

import com.obagajesse.BankingSystemAPI.DTO.AccountDTO;
import com.obagajesse.BankingSystemAPI.Entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO getAccountById(Long id);

    AccountDTO deposit(Long id,double amount);

    AccountDTO withdraw(Long id,double amount);

    List<AccountDTO> getAllAccounts();

    void deleteAccount(Long id);

}
