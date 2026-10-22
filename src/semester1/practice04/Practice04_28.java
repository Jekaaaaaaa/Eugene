package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Перший член a1: ");
            double first = scanner.nextDouble();
            System.out.print("Різниця d: ");
            double difference = scanner.nextDouble();
            System.out.print("Кількість членів n: ");
            int n = scanner.nextInt();
            if (n <= 0 || !Double.isFinite(first) || !Double.isFinite(difference)) {
                System.out.println("Потрібні скінченні a1, d та додатне n.");
                return;
            }
            double term = first;
            double sum = 0;
            for (int i = 0; i < n; i++) {
                System.out.print(term + " ");
                sum += term;
                term += difference;
            }
            System.out.println("\nСума: " + sum);
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
