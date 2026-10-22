package semester1.practice05;

public class Practice05_33 {
    public static void main(String[] args) {
        int[][] matrix = {{-5, 7, 12, -3}, {4, -9, 25, 8}, {11, 0, -6, 15}};
        int max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] > max) {
                    max = matrix[row][col];
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println("Максимум: " + max + " у комірці [" + maxRow + ", " + maxCol + "]");
    }
}
