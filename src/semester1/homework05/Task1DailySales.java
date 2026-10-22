package semester1.homework05;

import java.util.Locale;
import java.util.Scanner;

public class Task1DailySales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        double[] sales = new double[7];
        System.out.println("=== ФІНАНСОВИЙ ЗВІТ КАВ'ЯРНІ ЗА ТИЖДЕНЬ ===");
        for (int i = 0; i < sales.length; i++) {
            do {
                System.out.print("Введіть виторг за " + days[i] + " (грн, дробова частина через крапку): ");
                if (!scanner.hasNextDouble()) {
                    if (!scanner.hasNext()) { scanner.close(); return; }
                    scanner.next();
                    sales[i] = -1;
                } else {
                    sales[i] = scanner.nextDouble();
                }
                if (!Double.isFinite(sales[i]) || sales[i] < 0) {
                    System.out.println("Помилка: введіть невід'ємну скінченну суму!");
                }
            } while (!Double.isFinite(sales[i]) || sales[i] < 0);
        }
        double total = 0;
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < sales.length; i++) {
            total += sales[i];
            if (sales[i] > sales[maxIndex]) maxIndex = i;
            if (sales[i] < sales[minIndex]) minIndex = i;
        }
        double average = total / sales.length;
        System.out.printf(Locale.US, "Загальний тижневий виторг: %.2f грн%n", total);
        System.out.printf(Locale.US, "Середній виторг на день: %.2f грн%n", average);
        System.out.printf(Locale.US, "Найкращий день: %s (%.2f грн)%n", days[maxIndex], sales[maxIndex]);
        System.out.printf(Locale.US, "Найгірший день: %s (%.2f грн)%n", days[minIndex], sales[minIndex]);
        System.out.println("Дні з виторгом вище середнього:");
        boolean found = false;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > average) {
                System.out.printf(Locale.US, "- %s: %.2f грн%n", days[i], sales[i]);
                found = true;
            }
        }
        if (!found) System.out.println("Таких днів немає.");
        scanner.close();
    }
}
