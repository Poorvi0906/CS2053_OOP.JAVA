
import java.util.Scanner;

class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

public class AgeValidation {
    public AgeValidation() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User age: ");
        int age = scanner.nextInt();

        try {
            if (age < 18) {
                throw new UnderAgeException("You must be at least 18 years old!");
            }
            System.out.println("Valid age: " + age);
        } catch (UnderAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues...");
        scanner.close();
    }
}
