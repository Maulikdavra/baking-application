package com.md.bakingapplication.service.impl;

import com.md.bakingapplication.dao.AccountDao;
import com.md.bakingapplication.entity.Account;
import com.md.bakingapplication.mapper.AccountMapper;
import com.md.bakingapplication.repository.AccountRepository;
import com.md.bakingapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDao createAccount(AccountDao accountDao) {
        Account account = AccountMapper.mapToAccount(accountDao);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDao(savedAccount);
    }

    @Override
    public AccountDao getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountMapper.mapToAccountDao(account);
    }

    @Override
    public AccountDao deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDao(updatedAccount);
    }

    @Override
    public AccountDao withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDao(updatedAccount);
    }

    @Override
    public List<AccountDao> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        if (accounts.isEmpty()) {
            return Collections.emptyList();
        }
        return accounts.stream().map(AccountMapper::mapToAccountDao).toList();
    }

    @Override
    public AccountDao deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.delete(account);
        return AccountMapper.mapToAccountDao(account);
    }
}
