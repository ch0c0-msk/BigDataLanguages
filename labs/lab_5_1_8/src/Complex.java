public class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double real = this.real * other.real - this.imaginary * other.imaginary;
        double imaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(real, imaginary);
    }

    public Complex divide(Complex other) throws ArithmeticException {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        double real = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(real, imaginary);
    }

    public void set(Complex other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    public static Complex[] sumOfVectors(Complex[] vector1, Complex[] vector2) {
        if (vector1.length != vector2.length)
            throw new IllegalArgumentException("Vectors must be of the same length");

        Complex[] sum = new Complex[vector1.length];
        for (int i = 0; i < vector1.length; i++) {
            sum[i] = vector1[i].add(vector2[i]);
        }
        return sum;
    }

    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }
}

