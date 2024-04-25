import java.util.HashSet;

public class Main {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 1},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0}
        };

        System.out.println("Различные фигуры:");
        HashSet<String> figures = findFigures(grid);
        for (String figure : figures) {
            System.out.println(figure);
        }
    }

    private static HashSet<String> findFigures(int[][] grid) {
        HashSet<String> figures = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder figure = new StringBuilder();
                    dfs(grid, visited, i, j, i, j, figure);
                    figures.add(figure.toString());
                }
            }
        }

        return figures;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int startRow, int startCol, int currentRow, int currentCol, StringBuilder figure) {
        visited[currentRow][currentCol] = true;
        figure.append("(").append(currentRow).append(",").append(currentCol).append(")");

        for (int[] dir : DIRECTIONS) {
            int newRow = currentRow + dir[0];
            int newCol = currentCol + dir[1];

            if (isValid(grid, newRow, newCol) && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(grid, visited, startRow, startCol, newRow, newCol, figure);
            }
        }
    }

    private static boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
