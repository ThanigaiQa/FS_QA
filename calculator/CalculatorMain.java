import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            Calculator cal = new Calculator();
            int operator, n1, n2;
            System.out.println("1 - Add \n 2 -Subtract\n 3- Multiply\n 4- divide\n");
            System.out.print("choose the operator");
            operator = sc.nextInt();
            System.out.print("Enter first number");
            n1 = sc.nextInt();
            System.out.print("Enter second number");
            n2 = sc.nextInt();

            System.out.print(cal.operation(n1, n2, operator));
        System.out.println();
        System.out.println("do you want to perform more operation:yes/no");
        String value = sc.next();
        condition = value.equalsIgnoreCase("yes");
    }
        sc.close();
    }
}