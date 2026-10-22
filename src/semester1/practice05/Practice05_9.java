package semester1.practice05;

public class Practice05_9 {
    public static void main(String[] args) {
        int[] temps = {18, 21, 15, 24, 13, 27, 20};
        int min = temps[0];
        int max = temps[0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < min) {
                min = temps[i];
                minIndex = i;
            }
            if (temps[i] > max) {
                max = temps[i];
                maxIndex = i;
            }
        }
        System.out.println("Мінімум: " + min + ", індекс дня: " + minIndex);
        System.out.println("Максимум: " + max + ", індекс дня: " + maxIndex);
    }
}
