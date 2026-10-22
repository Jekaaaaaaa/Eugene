package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Початковий внесок S: ");
            double initial = scanner.nextDouble();
            System.out.print("Річний відсоток P: ");
            double percent = scanner.nextDouble();
            if (!Double.isFinite(initial) || !Double.isFinite(percent)
                    || initial <= 0 || percent <= 0 || !Double.isFinite(initial * 2)) {
                System.out.println("Потрібні додатні скінченні S і P; подвоєна сума має вміщатися в double.");
                return;
            }
            double capital = initial;
            long years = 0;
            while (capital < initial * 2) {
                double next = capital + capital * (percent / 100.0);
                if (next <= capital) {
                    System.out.println("Ставка надто мала для точності double.");
                    return;
                }
                capital = next;
                years++;
            }
            System.out.println("Капітал подвоїться через " + years + " років.");
            System.out.printf(Locale.US, "Кінцева сума: %.2f грн%n", capital);
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
