package model; // This declares that the class is part of the 'model' package. Packages help in organizing classes into namespaces.

public class User { // This declares a public class named 'User'. 'public' means this class can be accessed from other classes.

    private String accountNumber; // A private field to store the user's account number. 'private' means this field can only be accessed within this class.
    private String name; // A private field to store the user's name.
    private double balance; // A private field to store the user's account balance.

    public User(String accountNumber, String name, double initialBalance) { // A public constructor for the 'User' class. It initializes a new instance of the 'User' class with the given parameters.
        this.accountNumber = accountNumber; // The 'this' keyword refers to the current instance. This line sets the instance's accountNumber field to the value of the accountNumber parameter.
        this.name = name; // This line sets the instance's name field to the value of the name parameter.
        this.balance = initialBalance; // This line sets the instance's balance field to the value of the initialBalance parameter.
    }

    public String getAccountNumber() { // A public method to return the value of the accountNumber field.
        return accountNumber; // Returns the value of the accountNumber field.
    }

    public String getName() { // A public method to return the value of the name field.
        return name; // Returns the value of the name field.
    }

    public double getBalance() { // A public method to return the value of the balance field.
        return balance; // Returns the value of the balance field.
    }

    public void credit(double amount) { // A public method to add a given amount to the balance.
        if (amount > 0) { // Checks if the amount is greater than 0 to ensure only positive amounts are added.
            balance += amount; // Adds the amount to the balance.
        }
    }

    public void debit(double amount) { // A public method to subtract a given amount from the balance.
        if (amount > 0 && amount <= balance) { // Checks if the amount is greater than 0 and less than or equal to the balance to ensure valid transactions.
            balance -= amount; // Subtracts the amount from the balance.
        }
    }
}