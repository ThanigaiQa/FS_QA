package controller;

import model.Bank;  // Imports the Bank class from the model package.
import model.User;  // Imports the User class from the model package.
import persistence.DataPersistence;  // Imports the DataPersistence class from the persistence package.
import view.BankView;  // Imports the BankView class from the view package.

public class BankController {  // Declares the BankController class.
    private Bank model;  // Declares a private field for the Bank model.
    private BankView view;  // Declares a private field for the Bank view.

    public BankController(Bank model, BankView view) {  // Constructor for the BankController class.
        this.model = model;  // Initializes the model field with the provided Bank object.
        this.view = view;  // Initializes the view field with the provided BankView object.
    }

    public void run() {  // Method to run the controller.
        while (true) {  // Infinite loop to keep the application running.
            int choice = view.displayMenu();  // Displays the menu and gets the user's choice.
            switch (choice) {  // Switch statement to handle different menu options.
                case 1:
                    createUser();  // Calls the createUser method if the choice is 1.
                    break;
                case 2:
                    credit();  // Calls the credit method if the choice is 2.
                    break;
                case 3:
                    debit();  // Calls the debit method if the choice is 3.
                    break;
                case 4:
                    checkBalance();  // Calls the checkBalance method if the choice is 4.
                    break;
                case 5:
                    DataPersistence.saveData(model.getUsers());  // Saves the user data.
                    view.displayMessage("Thank you for using our application. Have a nice Day!");  // Displays a thank-you message.
                    return;  // Exits the loop and ends the method.
                default:
                    view.displayMessage("Invalid option");  // Displays an error message for invalid options.
            }
        }
    }

    private void createUser() {  // Private method to create a new user.
        String name = view.getInput("Enter name: ");  // Gets the user's name from the input.
        String accountNumber = model.generateUniqueAccountNumber();  // Generates a unique account number.
        User newUser = new User(accountNumber, name, 0);  // Creates a new User object with the initial balance set to 0.
        model.addUser(newUser);  // Adds the new user to the Bank model.
        view.displayMessage("User created successfully with Account Number: " + accountNumber + " Thank you for Choosing our Bank!!!");  // Displays a success message.
    }

    private void credit() {  // Private method to credit an amount to a user's account.
        String accountNumber = view.getInput("Enter account number: ");  // Gets the account number from the input.
        if (!isValidAccountNumber(accountNumber)) {  // Checks if the account number is valid.
            view.displayMessage("Invalid account number.");  // Displays an error message for an invalid account number.
            return;  // Exits the method.
        }
        double creditAmount = Double.parseDouble(view.getInput("Enter amount to credit: "));  // Gets the credit amount from the input and converts it to a double.
        if (creditAmount <= 0) {  // Checks if the credit amount is positive.
            view.displayMessage("Credit amount must be positive.");  // Displays an error message for a non-positive credit amount.
            return;  // Exits the method.
        }
        if (model.getUser(accountNumber) == null) {  // Checks if the account exists.
            view.displayMessage("Account not found.");  // Displays an error message if the account is not found.
            return;  // Exits the method.
        }
        model.credit(accountNumber, creditAmount);  // Credits the amount to the user's account.
        view.displayMessage("Amount credited successfully!");  // Displays a success message.
    }

    private void debit() {  // Private method to debit an amount from a user's account.
        String accountNumber = view.getInput("Enter account number: ");  // Gets the account number from the input.
        if (!isValidAccountNumber(accountNumber)) {  // Checks if the account number is valid.
            view.displayMessage("Invalid account number.");  // Displays an error message for an invalid account number.
            return;  // Exits the method.
        }
        double debitAmount = Double.parseDouble(view.getInput("Enter amount to debit: "));  // Gets the debit amount from the input and converts it to a double.
        User user = model.getUser(accountNumber);  // Retrieves the user by their account number.
        if (user == null) {  // Checks if the account exists.
            view.displayMessage("Account not found.");  // Displays an error message if the account is not found.
            return;  // Exits the method.
        }
        if (debitAmount <= 0) {  // Checks if the debit amount is positive.
            view.displayMessage("Debit amount must be positive.");  // Displays an error message for a non-positive debit amount.
            return;  // Exits the method.
        }
        if (debitAmount > user.getBalance()) {  // Checks if the user has sufficient funds.
            view.displayMessage("Insufficient funds.");  // Displays an error message for insufficient funds.
            return;  // Exits the method.
        }
        model.debit(accountNumber, debitAmount);  // Debits the amount from the user's account.
        view.displayMessage("Amount debited successfully!");  // Displays a success message.
    }

    private void checkBalance() {  // Private method to check the balance of a user's account.
        String accountNumber = view.getInput("Enter account number: ");  // Gets the account number from the input.
        if (!isValidAccountNumber(accountNumber)) {  // Checks if the account number is valid.
            view.displayMessage("Invalid account number.");  // Displays an error message for an invalid account number.
            return;  // Exits the method.
        }
        User user = model.getUser(accountNumber);  // Retrieves the user by their account number.
        if (user != null) {  // Checks if the account exists.
            double balance = user.getBalance();  // Gets the user's balance.
            String name = user.getName();  // Gets the user's name.
            view.displayMessage("Account Holder: " + name + "\nBalance: " + balance);  // Displays the account holder's name and balance.
        } else {
            view.displayMessage("Account not found.");  // Displays an error message if the account is not found.
        }
    }

    private boolean isValidAccountNumber(String accountNumber) {  // Private method to validate an account number.
        return accountNumber != null && !accountNumber.trim().isEmpty() && accountNumber.matches("SD\\d{4}");  // Returns true if the account number is not null, not empty, and matches the pattern "SD" followed by 4 digits.
    }
}
