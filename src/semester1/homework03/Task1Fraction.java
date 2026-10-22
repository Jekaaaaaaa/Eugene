package semester1.homework03;

import java.util.Locale;

public class Task1Fraction {
    public static void main(String[] args) {
        System.out.println("=== КАЛЬКУЛЯТОР ЗВИЧАЙНИХ ДРОБІВ ===");
        Fraction first = new Fraction();
        first.setValues(8, 12);
        System.out.print("Дріб 1: ");
        first.printFraction();
        first.simplify();
        System.out.print("Після скорочення: ");
        first.printFraction();
        System.out.printf(Locale.US, "Десятковий вигляд: %.4f%n", first.toDecimal());

        System.out.println("\nДодаємо 3/4 до 2/3...");
        first.add(3, 4);
        System.out.print("Результат додавання: ");
        first.printFraction();
        System.out.printf(Locale.US, "Десятковий вигляд: %.4f%n", first.toDecimal());

        Fraction second = new Fraction();
        second.setValues(6, -8);
        second.simplify();
        System.out.print("Дріб зі знаком у знаменнику: ");
        second.printFraction();

        Fraction third = new Fraction();
        third.setValues(4, 2);
        third.simplify();
        System.out.print("Цілий результат: ");
        third.printFraction();

        Fraction invalid = new Fraction();
        invalid.setValues(5, 0);
        System.out.print("Після перевірки нульового знаменника: ");
        invalid.printFraction();
    }
}

class Fraction {
    private int numerator;
    private int denominator = 1;

    public void setValues(int num, int den) {
        if (den == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            den = 1;
        }
        if (den < 0) {
            int normalizedNumerator = Math.negateExact(num);
            int normalizedDenominator = Math.negateExact(den);
            num = normalizedNumerator;
            den = normalizedDenominator;
        }
        this.numerator = num;
        this.denominator = den;
    }

    private int gcd(int a, int b) {
        long first = Math.abs((long) a);
        long second = Math.abs((long) b);
        while (second != 0) {
            long temp = second;
            second = first % second;
            first = temp;
        }
        return Math.toIntExact(first);
    }

    public void simplify() {
        int divisor = gcd(numerator, denominator);
        numerator /= divisor;
        denominator /= divisor;
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public void add(int otherNum, int otherDen) {
        if (otherDen == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            return;
        }
        Fraction other = new Fraction();
        other.setValues(otherNum, otherDen);
        int newNumerator = Math.addExact(Math.multiplyExact(numerator, other.denominator),
                Math.multiplyExact(other.numerator, denominator));
        int newDenominator = Math.multiplyExact(denominator, other.denominator);
        setValues(newNumerator, newDenominator);
        simplify();
    }

    public void printFraction() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }
}
