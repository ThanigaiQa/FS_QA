package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        List<String> history = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean checkingValue = true;

        while (checkingValue) {
            System.out.println("enter A value");
            int a = sc.nextInt();
            System.out.println("enter B value");
            int b = sc.nextInt();
            System.out.println("what operation do you want to do");
            System.out.println("these are the operations: + _ * /");
            String operation = sc.next();

            String result = "";
            switch (operation) {
                case "+":
                    result = "the addition is" + " " + (a + b);
                    break;
                case "-":
                    result = "the subtraction is" + " " + (a - b);
                    break;
                case "*":
                    result = "the multiplication is" + " " + (a * b);
                    break;
                case "/":
                    result = "the division is" + " " + (a / b);
                    break;
                default:
                    System.out.println("No Match");
            }
            System.out.println(result);
            history.add(result);

            System.out.println("Do you want to do another operation? (yes/no)");
            String continueResponse = sc.next();
            if (continueResponse.equalsIgnoreCase("no")) {
                checkingValue = false;
            }
        }
        System.out.println("Calculation History:");
        for (String record : history) {
            System.out.println(record);
        }

        sc.close();
    }
}
