package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.println("Вводьте цілі числа (0 — завершити):");
            long sum = 0;
            int number = scanner.nextInt();
            while (number != 0) {
                sum += number;
                number = scanner.nextInt();
            }
            System.out.println("Сума: " + sum);
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
