package org.example;

import org.example.model.User;
import org.example.service.serviceImpl.BankOperationServiceImpl;
import org.example.service.serviceImpl.UserServiceImpl;
import java.util.Scanner;

public class BankApplication
{
    public static void main( String[] args ) {
        String filePath = "C:\\Users\\sumyuktha\\Downloads\\bankingApplication.xlsx";
        UserServiceImpl userService = new UserServiceImpl(filePath);
        BankOperationServiceImpl bankOperation = new BankOperationServiceImpl(filePath);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Banking Application");
            System.out.println("1. Create User");
            System.out.println("2.get user details");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Please select an option: ");

            int choice  = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter userName");
                    String name = scanner.nextLine();
                    User newUser = userService.createUser(name);
                    System.out.println("User created with Account ID:" + newUser.getAccountId());
                    break;
                case 2:
                    System.out.println("Enter accountId to get user details");
                    String accountIdForUserDetails = scanner.nextLine();
                    User userDetails = userService.readUser(accountIdForUserDetails);
                    if (userDetails != null) {
                        System.out.println("User Details:");
                        System.out.println("Account ID: " + userDetails.getAccountId());
                        System.out.println("User Name: " + userDetails.getUserName());
                        System.out.println("Balance: " + userDetails.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter accountId to check balance");
                    String accountIdForCheckBalance = scanner.nextLine();
                    User user = userService.readUser(accountIdForCheckBalance);
                    if(user != null){
                        double amount = bankOperation.checkBalance(accountIdForCheckBalance);
                        System.out.println("balance for the given user is"+" "+amount);
                    }else{
                        System.out.println("Account not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter accountId to deposit money");
                    String accountIdForDeposit = scanner.nextLine();
                    User userForDeposit = userService.readUser(accountIdForDeposit);
                    if(userForDeposit != null){
                        System.out.println("amount to deposit");
                        double amountToDeposit = scanner.nextDouble();
                        bankOperation.deposit(accountIdForDeposit,amountToDeposit);
                        System.out.println("deposited"+" "+amountToDeposit +" "+"successfully");
                    }else{
                        System.out.println("account not found");
                    }
                    break;
                case 5:
                    System.out.println("Enter accountId to withdraw money");
                    String accountIdForWithdraw = scanner.nextLine();
                    User userForWithdraw = userService.readUser(accountIdForWithdraw);
                    if(userForWithdraw != null){
                        System.out.println("enter amount to withdraw");
                        double amountToWithdraw = scanner.nextDouble();
                        boolean success = bankOperation.withdraw(accountIdForWithdraw,amountToWithdraw);
                        if(success){
                            System.out.println("withdrew" +" "+amountToWithdraw+" "+"successfully");
                        }
                    }else {
                        System.out.println("account not found");
                    }
                    break;
                case 6:
                    System.out.println("existing application");
                    scanner.close();
                    return;
                default:
                    System.out.println("no matches : try again");
                    break;

            }
        }
    }
}
