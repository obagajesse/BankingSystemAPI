package com.obagajesse.BankingSystemAPI.Service.Impl;

import com.obagajesse.BankingSystemAPI.DTO.AccountDTO;
import com.obagajesse.BankingSystemAPI.Entity.Account;
import com.obagajesse.BankingSystemAPI.Mapper.AccountMapper;
import com.obagajesse.BankingSystemAPI.Repository.AccountRepository;
import com.obagajesse.BankingSystemAPI.Service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.mapToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long id) {

        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does Not Exist!"));
        return AccountMapper.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO deposit(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Deposit Not Possible."));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO withdraw(Long id, double amount) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does Not Exist."));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient Funds.");
        }

        double total = account.getBalance() - amount;

        account.setBalance(total);

        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());
        //return List.of();
    }

    @Override
    public void deleteAccount(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does Not Exist."));

        accountRepository.deleteById(id);
    }

}
