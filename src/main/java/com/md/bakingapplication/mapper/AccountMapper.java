package com.md.bakingapplication.mapper;

import com.md.bakingapplication.dao.AccountDao;
import com.md.bakingapplication.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDao accountDao) {
        Account account = new Account();
        account.setId(accountDao.getId());
        account.setAccountHolderName(accountDao.getAccountHolderName());
        account.setBalance(accountDao.getBalance());
        return account;
    }

    public static AccountDao mapToAccountDao(Account account) {
        AccountDao accountDao = new AccountDao();
        accountDao.setId(account.getId());
        accountDao.setAccountHolderName(account.getAccountHolderName());
        accountDao.setBalance(account.getBalance());
        return accountDao;
    }
}
