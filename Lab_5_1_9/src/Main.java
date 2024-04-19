public class Main {
    public static void main(String[] args) {
        QuadraticEquation[] equations = new QuadraticEquation[3];
        try {
            equations[0] = new QuadraticEquation(1, -3, 2);
            equations[1] = new QuadraticEquation(1, 4, 4);
            equations[2] = new QuadraticEquation(1, -6, 9);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
        double minRoot, maxRoot;
        try {
            minRoot = equations[0].findRoots()[0];
            maxRoot = equations[0].findRoots()[0];
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
        for (QuadraticEquation equation : equations) {
            try {
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
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("Minimum root: " + minRoot);
        System.out.println("Maximum root: " + maxRoot);
    }
}