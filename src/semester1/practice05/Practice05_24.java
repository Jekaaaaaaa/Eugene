package semester1.practice05;

public class Practice05_24 {
    public static void main(String[] args) {
        int[][] matrix = {{10, 20, 30, 40}, {50, 60, 70, 80}};
        System.out.println("Рядків: " + matrix.length);
        System.out.println("Стовпчиків: " + matrix[0].length);
        System.out.println("Лівий верхній: " + matrix[0][0]);
        System.out.println("Правий верхній: " + matrix[0][matrix[0].length - 1]);
        int last = matrix.length - 1;
        System.out.println("Лівий нижній: " + matrix[last][0]);
        System.out.println("Правий нижній: " + matrix[last][matrix[last].length - 1]);
    }
}
