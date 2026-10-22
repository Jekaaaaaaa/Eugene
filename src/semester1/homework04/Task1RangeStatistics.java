package semester1.homework04;

import java.util.Locale;
import java.util.Scanner;

public class Task1RangeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== АНАЛІЗАТОР ДІАПАЗОНУ ЧИСЕЛ ===");
        int n;
        do {
            System.out.print("Введіть додатне число N: ");
            if (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) { scanner.close(); return; }
                scanner.next();
                n = 0;
            } else {
                n = scanner.nextInt();
            }
            if (n <= 0) System.out.println("Помилка: введіть ціле число більше 0!");
        } while (n <= 0);

        long totalSum = 0;
        long evenSum = 0;
        long oddSum = 0;
        int evenCount = 0;
        int oddCount = 0;
        for (long i = 1; i <= n; i++) {
            totalSum += i;
            if (i % 2 == 0) {
                evenSum += i;
                evenCount++;
            } else {
                oddSum += i;
                oddCount++;
            }
        }
        double average = (double) totalSum / n;
        System.out.println("Загальна сума: " + totalSum);
        System.out.println("Сума парних: " + evenSum + " (кількість: " + evenCount + ")");
        System.out.println("Сума непарних: " + oddSum + " (кількість: " + oddCount + ")");
        System.out.printf(Locale.US, "Середнє арифметичне: %.2f%n", average);
        scanner.close();
    }
}
