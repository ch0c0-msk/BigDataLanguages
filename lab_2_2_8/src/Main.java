import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = generateMatrix(n);
        System.out.println("Matrix is:");
        printMatrix(matrix);
        System.out.printf("Determinant: %d", calculateDeterminant(matrix));
    }

    private static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        for (int i = 0; i < n; i++) {
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(minor(matrix, 0, i));
        }

        return determinant;
    }

    private static int[][] minor(int[][] matrix, int row, int col) {
        int n = matrix.length - 1;
        int[][] minor = new int[n][n];

        int minorRow = 0, minorCol;
        for (int i = 0; i < matrix.length; i++) {
            if (i == row) {
                continue;
            }
            minorCol = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == col) {
                    continue;
                }
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }

        return minor;
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