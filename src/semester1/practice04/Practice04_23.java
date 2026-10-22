package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.printf("%5s | %7s | %5s%n", "Число", "Квадрат", "Куб");
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%5d | %7d | %5d%n", i, i * i, i * i * i);
            }
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
