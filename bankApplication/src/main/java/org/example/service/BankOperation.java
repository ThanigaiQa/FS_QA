package org.example.service;

import org.example.model.User;

public interface BankOperation {
    double checkBalance(String accountId);
    void deposit(String accountId, double amount);
    boolean withdraw(String accountId, double amount);
}
