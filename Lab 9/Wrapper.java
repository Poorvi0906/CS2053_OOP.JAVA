
public class Wrapper {
    Integer i;

    public static void main(String[] args) {
        Wrapper w = new Wrapper();
        w.i = 10; // Autoboxing
        int j = w.i; // Unboxing
        System.out.println("Value of j: " + j);
    }
}
