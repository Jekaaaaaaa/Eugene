package semester1.practice05;

public class Practice05_31 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] rowSums = new int[3];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                rowSums[row] += matrix[row][col];
            }
            System.out.println("Рядок " + row + ": сума = " + rowSums[row]);
        }
    }
}
