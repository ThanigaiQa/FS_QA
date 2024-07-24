import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Simple Calculator!");

        while (true) {
            // Ask user for the operation type
            System.out.println("Enter operation type (+, -, *, /) or 'exit' to quit: ");
            String operationType = scanner.next().trim();

            // Exit condition
            if (operationType.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            if (!operationType.equals("+") && !operationType.equals("-") &&
                    !operationType.equals("*") && !operationType.equals("/")) {
                System.out.println("Invalid operation type. Please enter one of the following: +, -, *, /");
                continue;
            }

            // Read numbers from the user
            System.out.println("Enter numbers separated by spaces: ");
            scanner.nextLine(); // Consume newline left-over
            String[] numberInputs = scanner.nextLine().split("\\s+");

            if (numberInputs.length < 2) {
                System.out.println("Please enter at least two numbers.");
                continue;
            }

            double[] numbers = new double[numberInputs.length];
            try {
                for (int i = 0; i < numberInputs.length; i++) {
                    numbers[i] = Double.parseDouble(numberInputs[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter valid numbers.");
                continue;
            }

            double result = 0;
            boolean validOperation = true;

            switch (operationType) {
                case "+":
                    result = calculator.add(numbers);
                    break;
                case "-":
                    result = calculator.subtract(numbers);
                    break;
                case "*":
                    result = calculator.multiply(numbers);
                    break;
                case "/":
                    try {
                        result = calculator.divide(numbers);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Unsupported operator. Please use '+', '-', '*', or '/'.");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }
        }

        scanner.close();
    }

    // Method to perform addition on an array of numbers
    public double add(double[] numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Method to perform subtraction on an array of numbers
    public double subtract(double[] numbers) {
        double difference = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            difference -= numbers[i];
        }
        return difference;
    }

    // Method to perform multiplication on an array of numbers
    public double multiply(double[] numbers) {
        double product = 1;
        for (double num : numbers) {
            product *= num;
        }
        return product;
    }

    // Method to perform division on an array of numbers
    public double divide(double[] numbers) {
        double quotient = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            quotient /= numbers[i];
        }
        return quotient;
    }
}



