
public class Calculator {
    public static void main(String[] args) {
        System.out.println("Calculator program.");
        if (args.length < 3) {
            System.out.println("Please provide two integers and an operator (+, -, *, /) as command-line arguments.");
            return;
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String operator = args[2];
        int result = 0;
        switch (operator) {
        case "+" -> result = num1 + num2;
        case "-" -> result = num1 - num2;
        case "*" -> result = num1 * num2;
        case "/" -> {
            if (num2 == 0) {
                System.out.println("Cannot divide by zero.");
                return;
            }
            result = num1 / num2;
        }
        default -> {
            System.out.println("Invalid operator. Use +, -, *, or /.");
            return;
        }
    }
    System.out.println("Result: " + result);
}
}
