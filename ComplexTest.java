package a5;

import java.util.Scanner;

public class ComplexTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 
        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        Complex c1 = new Complex(a, b);

        // 
        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        Complex c2 = new Complex(c, d);

        // operations
        Complex sum = c1.add(c2);
        Complex difference = c1.subtract(c2);
        Complex product = c1.multiply(c2);
        Complex quotient = c1.divide(c2);
        double absoluteValue = c1.abs();

        // Display results
        System.out.println("(" + c1 + ") + (" + c2 + ") = " + sum);
        System.out.println("(" + c1 + ") - (" + c2 + ") = " + difference);
        System.out.println("(" + c1 + ") * (" + c2 + ") = " + product);
        System.out.println("(" + c1 + ") / (" + c2 + ") = " + quotient);
        System.out.println("|" + c1 + "| = " + absoluteValue);

        input.close();
    }
}
