package com.example.bankingmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankingmanagement.entity.BankAccount;
import com.example.bankingmanagement.entity.Transaction;
import com.example.bankingmanagement.repository.BankAccountRepository;
import com.example.bankingmanagement.repository.TransactionRepository;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public BankAccount createAccount(String ownerName, double balance) {
        BankAccount account = new BankAccount();
        account.setOwnerName(ownerName);
        account.setBalance(balance);
        return bankAccountRepository.save(account);
    }

    public BankAccount getAccount(Long id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    public BankAccount deposit(Long id, double amount) {
        BankAccount account = bankAccountRepository.findById(id).orElse(null);
        if (account == null) return null;

        account.setBalance(account.getBalance() + amount);
        bankAccountRepository.save(account);

        Transaction tx = new Transaction();
        tx.setAccountId(id);
        tx.setType("DEPOSIT");
        tx.setAmount(amount);
        transactionRepository.save(tx);

        return account;
    }

    public BankAccount withdraw(Long id, double amount) {
        BankAccount account = bankAccountRepository.findById(id).orElse(null);
        if (account == null || account.getBalance() < amount) return null;

        account.setBalance(account.getBalance() - amount);
        bankAccountRepository.save(account);

        Transaction tx = new Transaction();
        tx.setAccountId(id);
        tx.setType("WITHDRAW");
        tx.setAmount(amount);
        transactionRepository.save(tx);

        return account;
    }

    public String transfer(Long fromId, Long toId, double amount) {
        BankAccount from = bankAccountRepository.findById(fromId).orElse(null);
        BankAccount to = bankAccountRepository.findById(toId).orElse(null);

        if (from == null || to == null) {
            return "One or both accounts not found";
        }

        if (from.getBalance() < amount) {
            return "Insufficient balance";
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        bankAccountRepository.save(from);
        bankAccountRepository.save(to);

        Transaction tx = new Transaction();
        tx.setAccountId(fromId);
        tx.setType("TRANSFER");
        tx.setAmount(amount);
        transactionRepository.save(tx);

        return "Transfer successful";
    }
    public void deleteAccount(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
