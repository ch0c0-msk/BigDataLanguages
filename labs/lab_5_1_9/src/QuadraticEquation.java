public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) throws CustomException {
        if (a == 0) {
            throw new CustomException("A is zero");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(double a) throws CustomException {
        this(a, 0, 0);
    }

    public double[] findRoots() throws CustomException {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            throw new CustomException("Discriminant is less than zero");
        } else if (discriminant == 0) {
            return new double[]{-b / (2 * a)};
        } else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            return new double[]{
                    (-b + sqrtDiscriminant) / (2 * a),
                    (-b - sqrtDiscriminant) / (2 * a)
            };
        }
    }

    public double[] findExtremePoint() {
        double x = -b / (2 * a);
        double y = a * x * x + b * x + c;
        return new double[]{x, y};
    }

    public String findIntervalOfIncrease() {
        if (a > 0) {
            return "(-∞, +∞)";
        } else if (a < 0) {
            double extremePoint = findExtremePoint()[0];
            return "(-∞, " + extremePoint + ")";
        } else {
            return "There's no interval of increase or decrease.";
        }
    }

    public String findIntervalOfDecrease() {
        if (a < 0) {
            return "(-∞, +∞)";
        } else if (a > 0) {
            double extremePoint = findExtremePoint()[0];
            return "(" + extremePoint + ", +∞)";
        } else {
            return "There's no interval of increase or decrease.";
        }
    }
}
