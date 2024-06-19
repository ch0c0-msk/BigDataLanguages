import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }

        String filePath = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = reader.readLine();
            if (firstLine == null) {
                System.err.println("Empty file");
                return;
            }

            String[] elements = firstLine.split("\\s+");
            int rows = elements.length;
            int columns = 1;
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].length() > 1) {
                    System.err.println("Invalid matrix format");
                    return;
                }
            }

            char[][] matrix = new char[rows][rows];
            for (int i = 0; i < rows; i++) {
                if (i != 0) {
                    String line = reader.readLine();
                    if (line == null) {
                        System.err.println("Invalid number of rows");
                        return;
                    }
                    String[] rowElements = line.split("\\s+");
                    if (rowElements.length != rows) {
                        System.err.println("Invalid number of elements in row " + (i + 1));
                        return;
                    }
                    for (int j = 0; j < rows; j++) {
                        if (rowElements[j].length() != 1) {
                            System.err.println("Invalid matrix format");
                            return;
                        }
                        matrix[i][j] = rowElements[j].charAt(0);
                    }
                } else {
                    for (int j = 0; j < rows; j++) {
                        matrix[i][j] = elements[j].charAt(0);
                    }
                }
            }

            System.out.println("Исходная матрица:");
            printMatrix(matrix);

            char[][] transposedMatrix = transposeMatrix(matrix);

            System.out.println("\nТранспонированная матрица:");
            printMatrix(transposedMatrix);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static char[][] transposeMatrix(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        char[][] transposedMatrix = new char[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}
