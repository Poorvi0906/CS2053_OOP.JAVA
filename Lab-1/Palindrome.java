import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int reverse = 0;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }
        if (reverse == num) {
            System.out.println("The number " + num + " is a palindrome.");
        }
        else {
            System.out.println("The number " + num + " is not a palindrome.");
        }
    }
}

