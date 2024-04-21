package a5;

public class Complex implements Comparable<Complex> {
    private double real;
    private double imaginary;

    // Constructor 
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    //  one parameter
    public Complex(double real) {
        this(real, 0.0);
    }

    // Copy constructor
    public Complex(Complex other) {
        this(other.real, other.imaginary);
    }

    // work on this more 
    public Complex() {
        this(0.0, 0.0);
    }

    // 
    public double getRealPart() {
        return real;
    }

    // return the imaginary part (got it)
    public double getImaginaryPart() {
        return imaginary;
    }

    // 
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    // 
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    // 
    public Complex multiply(Complex other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.imaginary * other.real + this.real * other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    // 
    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(newReal, newImaginary);
    }

    // absolute value of this complex number
    public double abs() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    @Override
    public int compareTo(Complex other) {
        return Double.compare(this.abs(), other.abs());
    }

    @Override
    public String toString() {
        if (imaginary == 0) {
            return String.format("%.2f", real);
        }
        return String.format("%.2f %s %.2fi", real, imaginary < 0 ? "-" : "+", Math.abs(imaginary));
    }

    // 
    public static void main(String[] args) {
        Complex c1 = new Complex(5, 6);
        Complex c2 = new Complex(-3, 4);
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("Addition: " + c1.add(c2));
        System.out.println("Subtraction: " + c1.subtract(c2));
        System.out.println("Multiplication: " + c1.multiply(c2));
        System.out.println("Division: " + c1.divide(c2));
        System.out.println("Absolute value of c1: " + c1.abs());
        System.out.println("Comparison (c1 vs c2): " + c1.compareTo(c2));
    }
}
