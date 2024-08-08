package view;

import java.util.Scanner;

public class BankView {
    private Scanner scanner = new Scanner(System.in);

    public int displayMenu() {
        System.out.println("1. Create User");
        System.out.println("2. Credit");
        System.out.println("3. Debit");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
