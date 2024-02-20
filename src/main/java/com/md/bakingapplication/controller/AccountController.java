package com.md.bakingapplication.controller;

import com.md.bakingapplication.dao.AccountDao;
import com.md.bakingapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountDao> createAccount(@RequestBody AccountDao accountDao) {
        AccountDao createdAccount = accountService.createAccount(accountDao);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDao> getAccountById(@PathVariable Long id) {
        AccountDao account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDao> deposit(@PathVariable Long id, @RequestBody Map<String, Double> amount) {
        AccountDao account = accountService.deposit(id, amount.get("amount"));
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDao> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> amount) {
        AccountDao account = accountService.withdraw(id, amount.get("amount"));
        return ResponseEntity.ok(account);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDao>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDao> deleteAccount(@PathVariable Long id) {
        AccountDao account = accountService.deleteAccount(id);
        return ResponseEntity.ok(account);
    }
}
