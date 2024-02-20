package com.md.bakingapplication.service;

import com.md.bakingapplication.dao.AccountDao;
import com.md.bakingapplication.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDao createAccount(AccountDao accountDao);
    AccountDao getAccountById(Long id);
    AccountDao deposit(Long id, double amount);
    AccountDao withdraw(Long id, double amount);
    List<AccountDao> getAllAccounts();
    AccountDao deleteAccount(Long id);
}
