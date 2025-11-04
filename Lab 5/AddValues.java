public class AddValues {
    public static void add() {
        System.out.println("No input provided.");
    }

    public static void add(int a) {
        System.out.println("Single integer: " + a);
    }

    public static void add(int a, int b) {
        System.out.println("Sum of two integers: " + a + " + " + b + " = " + (a + b));
    }

    public static void add(double a) {
        System.out.println("Single double: " + a);
    }

    public static void add(String a, String b) {
        System.out.println("Concatenated result: " + a + b);
    }

    public static void main(String[] args) {
        add();
        add(5);
        add(3, 7);
        add(4.5);
        add("Hello, ", "World!");
    }
}
