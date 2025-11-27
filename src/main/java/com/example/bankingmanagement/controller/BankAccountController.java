package com.example.bankingmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingmanagement.entity.BankAccount;
import com.example.bankingmanagement.service.BankAccountService;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create")
    public BankAccount create(@RequestParam String ownerName,
                              @RequestParam double balance) {
        return bankAccountService.createAccount(ownerName, balance);
    }

    @GetMapping("/{id}")
    public BankAccount get(@PathVariable Long id) {
        return bankAccountService.getAccount(id);
    }

    @PostMapping("/deposit")
    public BankAccount deposit(@RequestParam Long id,
                               @RequestParam double amount) {
        return bankAccountService.deposit(id, amount);
    }

    @PostMapping("/withdraw")
    public BankAccount withdraw(@RequestParam Long id,
                                @RequestParam double amount) {
        return bankAccountService.withdraw(id, amount);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromId,
                           @RequestParam Long toId,
                           @RequestParam double amount) {
        return bankAccountService.transfer(fromId, toId, amount);
    }
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        bankAccountService.deleteAccount(id);
        return "Account deleted";
    }
}
