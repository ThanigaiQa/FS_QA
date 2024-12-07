package persistence; // Declares that this class is part of the 'persistence' package. Packages help organize related classes together.

import model.User; // Imports the 'User' class from the 'model' package. This allows us to use the 'User' class in this file.

import java.io.*; // Imports Java's I/O classes for file handling.
import java.util.HashMap; // Imports the HashMap class.
import java.util.Map; // Imports the Map interface.

public class DataPersistence { // Declares the public class 'DataPersistence'. Public means it can be accessed from other classes.
    private static final String FILE_NAME = "users.txt"; // Declares a constant string for the file name where user data will be saved.

    public static void saveData(Map<String, User> users) { // Declares a public static method 'saveData' that takes a Map of users.
        try (FileWriter writer = new FileWriter(FILE_NAME)) { // Tries to create a FileWriter to write to the specified file.
            for (User user : users.values()) { // Iterates over each User object in the Map.
                writer.write(user.getAccountNumber() + "," + user.getName() + "," + user.getBalance() + "\n"); // Writes the user's account number, name, and balance to the file, separated by commas.
            }
        } catch (IOException e) { // Catches any IOException that occurs during file writing.
            e.printStackTrace(); // Prints the stack trace of the exception.
        }
    }

    public static Map<String, User> loadData() { // Declares a public static method 'loadData' that returns a Map of users.
        Map<String, User> users = new HashMap<>(); // Creates an empty HashMap to store the users.
        File file = new File(FILE_NAME); // Creates a File object for the specified file name.

        if (!file.exists()) { // Checks if the file does not exist.
            System.out.println("No existing user data found. Starting with an empty database."); // Prints a message if the file does not exist.
            return users; // Returns the empty users map.
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) { // Tries to create a BufferedReader to read from the specified file.
            String line; // Declares a variable to store each line read from the file.
            while ((line = reader.readLine()) != null) { // Reads each line from the file until the end is reached.
                String[] parts = line.split(","); // Splits the line into parts using commas as delimiters.
                if (parts.length == 3) { // Checks if the line has exactly 3 parts.
                    String accountNumber = parts[0]; // Assigns the first part to accountNumber.
                    String name = parts[1]; // Assigns the second part to name.
                    double balance = Double.parseDouble(parts[2]); // Parses the third part as a double and assigns it to balance.
                    users.put(accountNumber, new User(accountNumber, name, balance)); // Creates a new User object and adds it to the users map.
                }
            }
        } catch (IOException e) { // Catches any IOException that occurs during file reading.
            e.printStackTrace(); // Prints the stack trace of the exception.
        }
        return users; // Returns the populated users map.
    }
}