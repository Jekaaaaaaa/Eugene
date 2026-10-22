package semester1.practice05;

public class Practice05_35 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposed = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        System.out.println("Початкова\t\tТранспонована");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\t");
            for (int j = 0; j < transposed[i].length; j++) {
                System.out.print(transposed[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
