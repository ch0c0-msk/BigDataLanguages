public class Main {
    public static void main(String[] args) {
        QuadraticEquation[] equations = {
                new QuadraticEquation(1, -3, 2),
                new QuadraticEquation(1, 4, 4),
                new QuadraticEquation(1, -6, 9)
        };

        double minRoot = equations[0].findRoots()[0];
        double maxRoot = equations[0].findRoots()[0];

        for (QuadraticEquation equation : equations) {
            double[] roots = equation.findRoots();
            for (double root : roots) {
                if (!Double.isNaN(root)) {
                    if (root < minRoot) {
                        minRoot = root;
                    }
                    if (root > maxRoot) {
                        maxRoot = root;
                    }
                }
            }
        }

        System.out.println("Minimum root: " + minRoot);
        System.out.println("Maximum root: " + maxRoot);
    }
}