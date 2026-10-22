package semester1.practice05;

public class Practice05_30 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = 0;
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
                count++;
            }
        }
        System.out.println("Сума: " + sum);
        System.out.println("Кількість: " + count);
        System.out.println("Середнє: " + (double) sum / count);
    }
}
