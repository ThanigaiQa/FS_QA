import java.util.Scanner;

class Operations
{
    Scanner s = new Scanner(System.in);
    int x = s.nextInt();
    int y = s.nextInt();

    public void Addition() {

        // int x = s.nextInt();
        // int y = s.nextInt();
        System.out.println("**********************************");
        System.out.println("Enter first num :" + x);
        System.out.println("Enter first num :" + y);
        System.out.println("Addition of two numbers is :" + (x + y));
        System.out.println("**********************************");
    }

    public void Substraction() {

        // int x = s.nextInt();
        // int y = s.nextInt();
        System.out.println("Enter first num :" + x);
        System.out.println("Enter first num :" + y);
        System.out.println("Substraction of two numbers is :" + (x - y));
        System.out.println("**********************************");
    }

    public void Multiplication() {

        // int x = s.nextInt();
        // int y = s.nextInt();
        System.out.println("Enter first num :" + x);
        System.out.println("Enter first num :" + y);
        System.out.println("Multiplication of two numbers is :" + (x * y));
        System.out.println("**********************************");
    }

    public void Division() {

        // int x = s.nextInt();
        // int y = s.nextInt();
        System.out.println("Enter first num :" + x);
        System.out.println("Enter first num :" + y);
        System.out.println("Division of two numbers is :" + (x / y));
        System.out.println("**********************************");
    }
}

public class Calculator extends Operations
 {
    public static void main(String[] args) {

        Calculator cal = new Calculator();
        cal.Addition();
        cal.Substraction();
        cal.Multiplication();
        cal.Division();
    }

}
