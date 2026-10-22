package semester1.homework03;

import java.util.Locale;

public class Task2QuadraticEquation {
    public static void main(String[] args) {
        System.out.println("=== РОЗВ'ЯЗУВАЧ КВАДРАТНИХ РІВНЯНЬ ===");
        QuadraticEquation first = new QuadraticEquation();
        first.setCoefficients(1, -5, 6);
        System.out.println("\nТест 1: два корені");
        first.printSolution();

        QuadraticEquation second = new QuadraticEquation();
        second.setCoefficients(1, -4, 4);
        System.out.println("\nТест 2: один корінь");
        second.printSolution();

        QuadraticEquation third = new QuadraticEquation();
        third.setCoefficients(1, 2, 5);
        System.out.println("\nТест 3: немає дійсних коренів");
        third.printSolution();

        QuadraticEquation invalid = new QuadraticEquation();
        System.out.println("\nПеревірка a = 0:");
        invalid.setCoefficients(0, -5, 6);
        invalid.printSolution();
    }
}

class QuadraticEquation {
    private double a = 1.0;
    private double b;
    private double c;

    public void setCoefficients(double a, double b, double c) {
        if (!Double.isFinite(a) || !Double.isFinite(b) || !Double.isFinite(c)) {
            throw new IllegalArgumentException("Коефіцієнти мають бути скінченними числами.");
        }
        if (a == 0) {
            System.out.println("Увага: коефіцієнт 'a' не може дорівнювати 0 (це лінійне рівняння)!");
            a = 1.0;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return Double.NaN;
        }
        return (-b + Math.sqrt(discriminant)) / (2 * a);
    }

    public double getRoot2() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return Double.NaN;
        }
        return (-b - Math.sqrt(discriminant)) / (2 * a);
    }

    public void printSolution() {
        System.out.printf(Locale.US, "Рівняння: %.2f*x^2 %+.2f*x %+.2f = 0%n", a, b, c);
        double discriminant = getDiscriminant();
        System.out.printf(Locale.US, "Дискримінант D = %.2f%n", discriminant);
        if (discriminant > 0) {
            System.out.printf(Locale.US, "Рівняння має 2 дійсні корені:%n  x1 = %.2f%n  x2 = %.2f%n",
                    getRoot1(), getRoot2());
        } else if (discriminant == 0) {
            System.out.printf(Locale.US, "Рівняння має один дійсний корінь:%n  x = %.2f%n", -b / (2 * a));
        } else {
            System.out.println("Рівняння не має дійсних коренів (D < 0)");
        }
    }
}
