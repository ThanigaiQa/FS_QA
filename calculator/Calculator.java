import java.util.Scanner;

public class Calculator {

    public int operation(int n1, int n2, int operator) {
        int result = 0;
        switch (operator) {
            case 1:
                result = n1 + n2;
                break;
            case 2:
                result = n1 - n2;
                break;
            case 3:
                result = n1 * n2;
                break;
            case 4:
                result = n1 / n2;
                break;

            default:
                System.out.println("Entered operator is Invalid");

        }
        return result;
    }
}

