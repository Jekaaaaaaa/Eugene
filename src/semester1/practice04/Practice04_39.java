package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Верхня межа N: ");
            int n = scanner.nextInt();
            if (n < 2) {
                System.out.println("У цьому діапазоні немає простих чисел.");
                return;
            }
            for (long number = 2; number <= n; number++) {
                boolean prime = true;
                for (long divisor = 2; divisor <= number / divisor; divisor++) {
                    if (number % divisor == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();
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
