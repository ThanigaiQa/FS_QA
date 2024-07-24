package calculator;


import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> history;

    public Calculator() {
        this.history = new ArrayList<>();
    }

    public String operation(int a, int b, String operation) {
        String result = "";
        switch (operation) {
            case "+":
                result = a + " " + operation + " " + b + " = " + (a + b);
                break;
            case "-":
                result = a + " " + operation + " " + b + " = " + (a - b);
                break;
            case "*":
                result = a + " " + operation + " " + b + " = " + (a * b);
                break;
            case "/":
                if (b != 0) {
                    result = a + " " + operation + " " + b + " = " + (a / b);
                } else {
                    result = "Error: Division by zero";
                }
                break;
            case "history":
                getHistory();
            default:
                System.out.println("No Match");
        }
        history.add(result);
        return result;
    }

    public void getHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available");
        } else {
            System.out.println("calculation history");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}
