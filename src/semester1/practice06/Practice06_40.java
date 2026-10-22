package semester1.practice06;

import java.util.Locale;

public class Practice06_40 {
    public static void main(String[] args) {
        MatrixDiagonals diagonals = new MatrixDiagonals();
        diagonals.setMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println("Головна діагональ: " + diagonals.getMainDiagonalSum());
        System.out.println("Побічна діагональ: " + diagonals.getAntiDiagonalSum());
        System.out.println("Суми діагоналей рівні: " + diagonals.isDiagonalSymmetric());
    }

    static class MatrixDiagonals {
        private int[][] matrix = new int[0][0];
    
        public void setMatrix(int[][] matrix) {
            if (matrix == null) {
                throw new IllegalArgumentException("Матриця не може бути null.");
            }
            int[][] copy = new int[matrix.length][];
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i] == null || matrix[i].length != matrix.length) {
                    throw new IllegalArgumentException("Потрібна квадратна матриця.");
                }
                copy[i] = matrix[i].clone();
            }
            this.matrix = copy;
        }
    
        public int getMainDiagonalSum() {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum = Math.addExact(sum, matrix[i][i]);
            }
            return sum;
        }
    
        public int getAntiDiagonalSum() {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum = Math.addExact(sum, matrix[i][matrix.length - 1 - i]);
            }
            return sum;
        }
    
        public boolean isDiagonalSymmetric() {
            return getMainDiagonalSum() == getAntiDiagonalSum();
        }
    }
}
