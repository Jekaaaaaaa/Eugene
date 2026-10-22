package semester1.practice06;

import java.util.Locale;

public class Practice06_39 {
    public static void main(String[] args) {
        Matrix2D matrix = new Matrix2D();
        matrix.setGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        matrix.printMatrix();
        System.out.println("Загальна сума: " + matrix.getTotalSum());
        System.out.println("Сума рядка з індексом 1: " + matrix.getRowSum(1));
    }

    static class Matrix2D {
        private int[][] grid = new int[0][0];
    
        public void setGrid(int[][] grid) {
            if (grid == null) {
                throw new IllegalArgumentException("Матриця не може бути null.");
            }
            int columns = grid.length == 0 ? 0 : (grid[0] == null ? -1 : grid[0].length);
            int[][] copy = new int[grid.length][];
            for (int i = 0; i < grid.length; i++) {
                if (grid[i] == null || grid[i].length != columns) {
                    throw new IllegalArgumentException("Матриця має бути прямокутною.");
                }
                copy[i] = grid[i].clone();
            }
            this.grid = copy;
        }
    
        public void printMatrix() {
            for (int[] row : grid) {
                for (int value : row) {
                    System.out.printf("%6d", value);
                }
                System.out.println();
            }
        }
    
        public int getTotalSum() {
            int sum = 0;
            for (int[] row : grid) {
                for (int value : row) {
                    sum = Math.addExact(sum, value);
                }
            }
            return sum;
        }
    
        public int getRowSum(int rowIndex) {
            if (rowIndex < 0 || rowIndex >= grid.length) {
                throw new IllegalArgumentException("Неправильний індекс рядка.");
            }
            int sum = 0;
            for (int value : grid[rowIndex]) {
                sum = Math.addExact(sum, value);
            }
            return sum;
        }
    }
}
