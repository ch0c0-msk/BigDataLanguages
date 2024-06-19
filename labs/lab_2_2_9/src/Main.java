import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = generateMatrix(n);
        System.out.println("Original matrix is:");
        printMatrix(matrix);
        System.out.println("Custom matrix is:");
        printMatrix(generateCustomMatrix(matrix));
    }

    private static int[][] generateCustomMatrix(int[][] source) {
        int size = source[0].length;
        int[][] customMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum += source[i][j];
            }

            int average = sum / size;

            for (int j = 0; j < size; j++) {
                customMatrix[i][j] = source[i][j] - average;
            }
        }

        return customMatrix;
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}