
import java.util.Scanner;
class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

public class PasswordStrengthCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        try {
            if (password.length() < 6) {
                throw new WeakPasswordException("Password is too weak! It must be at least 6 characters long.");
            }
            System.out.println("Password Accepted!");
        } catch (WeakPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Program continues...");
        sc.close();
    }
}
