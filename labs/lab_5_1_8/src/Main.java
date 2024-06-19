public class Main {
    public static void main(String[] args) {
        Complex[] vector1 = new Complex[]{
                new Complex(1, 1), new Complex(1, 1), new Complex(0, 0)
        };
        Complex[] vector2 = new Complex[]{
                new Complex(1, 1), new Complex(2, 2), new Complex(0, 0)
        };
        Complex[] res = Complex.sumOfVectors(vector1, vector2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        Complex c1 = new Complex(1, 1);
        Complex c2 = new Complex(0, 0);
        try {
            System.out.println(c1.divide(c2));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}