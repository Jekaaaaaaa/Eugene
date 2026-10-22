package semester1.practice05;

import java.util.Arrays;

public class Practice05_29 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int row = 0; row < matrix.length; row++) {
            Arrays.fill(matrix[row], 1);
        }
        Arrays.fill(matrix[1], 0);
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][2] = 7;
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
