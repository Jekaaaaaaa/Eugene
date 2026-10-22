package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            double[] prices = {19.99, 45.50, 12.10, 99.95, 3.40};
            int hryvnias = 0;
            int kopecks = 0;
            for (int i = 0; i < prices.length; i++) {
                int whole = (int) prices[i];
                hryvnias += whole;
                // Округлення прибирає похибку двійкового представлення дробової частини.
                kopecks += (int) Math.round((prices[i] - whole) * 100);
            }
            System.out.println("Сума цілих гривень: " + hryvnias + " грн");
            System.out.println("Сума відкинутих копійок: " + kopecks + " коп.");
            System.out.printf(Locale.US, "Відкинута сума у гривнях: %.2f грн%n", kopecks / 100.0);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Некоректний формат введення. Дробові числа вводьте через крапку.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Введення завершилося раніше, ніж очікувалося.");
        } catch (ArithmeticException e) {
            System.out.println("Результат не вміщується у вибраний числовий тип.");
        } finally {
            scanner.close();
        }
    }

}
