package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            for (int i = 1; i <= 50; i++) {
                int percent = (int) (((double) i / 50) * 100);
                System.out.println("Завантажено: " + percent + "%");
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
