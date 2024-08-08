import controller.BankController;  // Imports the BankController class from the controller package.
import model.Bank;  // Imports the Bank class from the model package.
import model.User;  // Imports the User class from the model package.
import persistence.DataPersistence;  // Imports the DataPersistence class from the persistence package.
import view.BankView;  // Imports the BankView class from the view package.

import java.util.Map;  // Imports the Map interface from the java.util package.

public class BankApplication {  // Declares the BankApplication class. This is the entry point for the application.

    public static void main(String[] args) {  // The main method is the entry point of the application.
        Bank model = new Bank();  // Creates an instance of the Bank class. This is the model part of the MVC pattern.
        BankView view = new BankView();  // Creates an instance of the BankView class. This is the view part of the MVC pattern.
        BankController controller = new BankController(model, view);  // Creates an instance of the BankController class, passing the model and view. This is the controller part of the MVC pattern.

        Map<String, User> users = DataPersistence.loadData();  // Loads the user data from persistence. This returns a map of users keyed by their account numbers.
        for (User user : users.values()) {  // Iterates over each user in the map.
            model.addUser(user);  // Adds each user to the Bank model.
        }

        controller.run();  // Starts the controller, which begins the user interaction loop.
    }
}
