package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("What operation do you want to do?");
            System.out.println("These are the operations: + - * / history");
            String operation = scanner.next();

            if (operation.equals("history")) {
                calculator.getHistory();
            } else {
                System.out.println("Enter A value:");
                int a = scanner.nextInt();
                System.out.println("Enter B value:");
                int b = scanner.nextInt();
                String result = calculator.operation(a, b, operation);
                System.out.println(result);
            }
            System.out.println("Do you want to do another operation? (yes/no)");
            String response = scanner.next();
            continueCalculation = response.equalsIgnoreCase("yes");
        }
        scanner.close();
    }
}
