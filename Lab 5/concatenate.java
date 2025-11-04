
public class Concatenate {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide at least three strings as command-line arguments.");
            return;
        }
        String str1 = args[0];
        String str2 = args[1];
        String str3 = args[2];
        String result = str1 + " " + str2 + " " + str3;
        System.out.println("Concatenated result of " + str1 + ", " + str2 + ", and " + str3 + " is: " + result);
    }
}
