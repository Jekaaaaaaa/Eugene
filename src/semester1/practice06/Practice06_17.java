package semester1.practice06;

import java.util.Locale;

public class Practice06_17 {
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        int sum = calculator.add(10, 3);
        int difference = calculator.subtract(10, 3);
        int multiplication = calculator.multiply(10, 3);
        double quotient = calculator.divide(10, 3);
        System.out.println("Сума: " + sum + "; різниця: " + difference
                + "; добуток: " + multiplication + "; частка: " + quotient);
        double zeroDivision = calculator.divide(10, 0);
        System.out.println("Результат при нульовому дільнику: " + zeroDivision);
    }

    static class SimpleCalculator {
        public int add(int a, int b) {
            return a + b;
        }
    
        public int subtract(int a, int b) {
            return a - b;
        }
    
        public int multiply(int a, int b) {
            return a * b;
        }
    
        public double divide(int a, int b) {
            if (b == 0) {
                System.out.println("Помилка: ділення на нуль.");
                return 0.0;
            }
            return (double) a / b;
        }
    }
}
