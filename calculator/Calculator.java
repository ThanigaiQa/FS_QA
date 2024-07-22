import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private int answer;

    public void calculation(String op, int a, int b) {
        boolean condition = true;
        List<Integer> historyList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (condition) {
            switch (op.toLowerCase()) {
                case "addition":
                    answer = a + b;
                    System.out.println("The Addition value is " + answer);
                    break;
                case "subtraction":
                    answer = a - b;
                    System.out.println("The Subtraction value is " + answer);
                    break;
                case "multiplication":
                    answer = a * b;
                    System.out.println("The Multiplication value is " + answer);
                    break;
                case "division":
                    if (b != 0) {
                        answer = a / b;
                        System.out.println("The Division value is  " + answer);
                    } else {
                        System.out.println("Division by zero is not allowed.");
                    }
                    break;
                default:
                    System.out.println("Not a valid operation.");
            }

            historyList.add(answer);

            System.out.println("Do you want to perform another operation? (YES/NO)");
            String value = sc.next();
            if (value.equalsIgnoreCase("yes")) {
                condition = true;
            }
            else{
                condition =false;
            }
        }

        System.out.println("Calculation history:");
        for (Integer record : historyList) {
            System.out.println(record);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value of a:");
        int a = sc.nextInt();
        System.out.println("Enter value of b:");
        int b = sc.nextInt();

        System.out.println("Enter Operation (Addition, Subtraction, Multiplication, Division):");
        String op = sc.next();

        calculator.calculation(op, a, b);

        sc.close();
    }
}