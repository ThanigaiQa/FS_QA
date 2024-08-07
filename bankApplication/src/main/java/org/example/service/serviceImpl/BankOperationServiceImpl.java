package org.example.service.serviceImpl;

import org.example.model.User;
import org.example.service.BankOperation;
import org.example.service.ExcelService;

public class BankOperationServiceImpl implements BankOperation {
    private final ExcelService excelService;

    public BankOperationServiceImpl(String excelPath) {
        this.excelService = new ExcelServiceImpl(excelPath);
    }

    @Override
    public double checkBalance(String accountId) {
        User user = excelService.readUser(accountId);
        if (user != null) {
            return user.getBalance();
        }
        return 0.0;
    }

    @Override
    public void deposit(String accountId, double amount) {
        User user = excelService.readUser(accountId);
        if (user != null) {
            double newBalance = user.getBalance() + amount;
            user.setBalance(newBalance);
            excelService.write(user);
        } else {
            System.out.println("user not found");
        }
    }

    @Override
    public boolean withdraw(String accountId, double amount) {
        User user = excelService.readUser(accountId);
        if(user != null){
            if (user.getBalance() >= amount) {
                double newBalance = user.getBalance() - amount;
                user.setBalance(newBalance);
                excelService.write(user);
                return true;
            } else {
                System.out.println("insufficient balance");
                return false;
            }
        }else {
            System.out.println("user not found");
            return false;
        }
    }
}
