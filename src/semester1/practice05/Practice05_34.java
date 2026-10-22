package semester1.practice05;

public class Practice05_34 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int mainSum = 0;
        int sideSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            mainSum += matrix[i][i];
            sideSum += matrix[i][matrix.length - 1 - i];
        }
        System.out.println("Головна діагональ: " + mainSum);
        System.out.println("Побічна діагональ: " + sideSum);
        if (mainSum > sideSum) {
            System.out.println("Сума головної діагоналі більша.");
        } else if (mainSum < sideSum) {
            System.out.println("Сума побічної діагоналі більша.");
        } else {
            System.out.println("Суми рівні.");
        }
    }
}
