/* write a program in java to add and substract complex number 
1. use constructor overloading 
2. function overloading 
3. inheritance */ 

// Base class
class Complex {
    double real, imag;

    // Constructor Overloading
    Complex() {
        real = 0;
        imag = 0;
    }

    Complex(double r, double i) {
        real = r;
        imag = i;
    }

    // Method Overloading
    Complex add(Complex c) {
        return new Complex(real + c.real, imag + c.imag);
    }

    Complex subtract(Complex c) {
        return new Complex(real - c.real, imag - c.imag);
    }

    void show(String label) {
        System.out.println(label + ": " + real + " + " + imag + "i");
    }
}

// Derived class
class AdvancedComplex extends Complex {
    AdvancedComplex(double r, double i) {
        super(r, i);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        AdvancedComplex c1 = new AdvancedComplex(4, 5);
        AdvancedComplex c2 = new AdvancedComplex(2, 3);

        Complex sum = c1.add(c2);
        Complex diff = c1.subtract(c2);

        sum.show("Sum");
        diff.show("Difference");
    }
}








