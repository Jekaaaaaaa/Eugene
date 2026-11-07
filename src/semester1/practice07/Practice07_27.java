package semester1.practice07;

public class Practice07_27 {
    public static void main(String[] args) {
        System.out.println("5! = " + MathUtils.factorial(5));
        System.out.println("2^(-3) = " + MathUtils.power(2.0, -3));
        System.out.println("НСД(48, 18) = " + MathUtils.gcd(48, 18));
        System.out.println("Число 12 в межах [0; 10]: " + MathUtils.clamp(12, 0, 10));
    }

    static class MathUtils {
        public static final double PI = 3.1415926535;
        public static final double E = 2.7182818284;

        private MathUtils() {
        }

        public static long factorial(int n) {
            if (n < 0 || n > 20) {
                throw new IllegalArgumentException("Факторіал типу long визначено для 0–20");
            }
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }

        public static double power(double base, int exp) {
            return Math.pow(base, exp);
        }

        public static int gcd(int a, int b) {
            long first = Math.abs((long) a);
            long second = Math.abs((long) b);
            while (second != 0) {
                long remainder = first % second;
                first = second;
                second = remainder;
            }
            return Math.toIntExact(first);
        }

        public static int clamp(int val, int min, int max) {
            if (min > max) {
                throw new IllegalArgumentException("Мінімум більший за максимум");
            }
            return Math.max(min, Math.min(val, max));
        }
    }
}
