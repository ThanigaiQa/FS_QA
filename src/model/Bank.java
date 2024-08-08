package model; // This declares the package for this class. Packages are used to group related classes together.

import java.io.BufferedReader;  // Imports the BufferedReader class for reading text from an input stream.
import java.io.FileReader;  // Imports the FileReader class for reading character files.
import java.io.FileWriter;  // Imports the FileWriter class for writing character files.
import java.io.IOException;  // Imports the IOException class to handle input-output exceptions.
import java.util.HashMap;  // Imports the HashMap class for storing key-value pairs.
import java.util.Map;  // Imports the Map interface for mapping keys to values.

public class Bank {
    private Map<String, User> users = new HashMap<>();  // Creates a HashMap to store users with their account numbers as keys.
    private static final String COUNTER_FILE = "counter.txt";  // Declares a constant for the file name that stores the account number counter.
    private static final String PREFIX = "SD";  // Declares a constant prefix for account numbers.
    private static int accountNumberCounter;  // Declares a static counter for generating unique account numbers.

    public Bank() {  // Constructor for the Bank class.
        accountNumberCounter = loadCounter();  // Initializes the account number counter by loading it from the file.
    }

    public void addUser(User user) {  // Method to add a user to the bank.
        users.put(user.getAccountNumber(), user);  // Adds the user to the HashMap using their account number as the key.
        saveCounter(accountNumberCounter);  // Saves the updated counter to the file.
    }

    public User getUser(String accountNumber) {  // Method to retrieve a user by their account number.
        return users.get(accountNumber);  // Returns the user associated with the given account number.
    }

    public void credit(String accountNumber, double amount) {  // Method to credit an amount to a user's account.
        User user = getUser(accountNumber);  // Retrieves the user by their account number.
        if (user != null) {  // Checks if the user exists.
            user.credit(amount);  // Credits the amount to the user's account.
        }
    }

    public void debit(String accountNumber, double amount) {  // Method to debit an amount from a user's account.
        User user = getUser(accountNumber);  // Retrieves the user by their account number.
        if (user != null) {  // Checks if the user exists.
            user.debit(amount);  // Debits the amount from the user's account.
        }
    }

    public double checkBalance(String accountNumber) {  // Method to check the balance of a user's account.
        User user = getUser(accountNumber);  // Retrieves the user by their account number.
        if (user != null) {  // Checks if the user exists.
            return user.getBalance();  // Returns the user's balance.
        }
        return 0;  // Returns 0 if the user does not exist.
    }

    public Map<String, User> getUsers() {  // Method to get the map of all users.
        return users;  // Returns the HashMap of users.
    }

    public String generateUniqueAccountNumber() {  // Method to generate a unique account number.
        accountNumberCounter++;  // Increments the account number counter.
        return String.format("%s%04d", PREFIX, accountNumberCounter);  // Returns a unique account number with the prefix and a 4-digit suffix.
    }

    private int loadCounter() {  // Private method to load the account number counter from the file.
        try (BufferedReader br = new BufferedReader(new FileReader(COUNTER_FILE))) {  // Tries to create a BufferedReader to read from the file.
            return Integer.parseInt(br.readLine());  // Parses and returns the counter value from the file.
        } catch (IOException | NumberFormatException e) {  // Catches exceptions if the file doesn't exist or the format is incorrect.
            return 0;  // Returns 0 if an exception occurs.
        }
    }

    private void saveCounter(int counter) {  // Private method to save the account number counter to the file.
        try (FileWriter fw = new FileWriter(COUNTER_FILE)) {  // Tries to create a FileWriter to write to the file.
            fw.write(String.valueOf(counter));  // Writes the counter value to the file.
        } catch (IOException e) {  // Catches IO exceptions.
            e.printStackTrace();  // Prints the stack trace if an exception occurs.
        }
    }
}
