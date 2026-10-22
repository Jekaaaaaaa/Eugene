package semester1.practice05;

public class Practice05_28 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = row == col ? 1 : 0;
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
