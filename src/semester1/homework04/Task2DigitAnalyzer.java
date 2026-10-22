package semester1.homework04;

import java.util.Scanner;

public class Task2DigitAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== АНАЛІЗАТОР РОЗРЯДІВ ЧИСЛА ===");
        int number;
        do {
            System.out.print("Введіть додатне ціле число: ");
            if (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) { scanner.close(); return; }
                scanner.next();
                number = 0;
            } else {
                number = scanner.nextInt();
            }
            if (number <= 0) System.out.println("Помилка: число має бути додатним!");
        } while (number <= 0);
        int originalNumber = number;
        int temp = number;
        int digitCount = 0;
        int digitSum = 0;
        int maxDigit = 0;
        long reversedNumber = 0;
        while (temp > 0) {
            int digit = temp % 10;
            digitCount++;
            digitSum += digit;
            if (digit > maxDigit) maxDigit = digit;
            reversedNumber = reversedNumber * 10 + digit;
            temp /= 10;
        }
        System.out.println("Початкове число: " + originalNumber);
        System.out.println("Кількість цифр: " + digitCount);
        System.out.println("Сума цифр: " + digitSum);
        System.out.println("Найбільша цифра: " + maxDigit);
        System.out.println("Перевернуте число: " + reversedNumber);
        if (originalNumber == reversedNumber) {
            System.out.println("Це число є паліндромом!");
        } else {
            System.out.println("Це звичайне число (не паліндром).");
        }
        scanner.close();
    }
}
