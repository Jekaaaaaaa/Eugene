package semester1.practice06;

import java.util.Locale;

public class Practice06_20 {
    public static void main(String[] args) {
        NumberChecker checker = new NumberChecker();
        int[] checkedNumbers = {7, 12, -5};
        for (int number : checkedNumbers) {
            System.out.println(number + ": парне=" + checker.isEven(number)
                    + ", додатне=" + checker.isPositive(number) + ", просте=" + checker.isPrime(number));
        }
    }

    static class NumberChecker {
        public boolean isEven(int n) {
            return n % 2 == 0;
        }
    
        public boolean isPositive(int n) {
            return n > 0;
        }
    
        public boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            for (int divisor = 2; divisor <= n / divisor; divisor++) {
                if (n % divisor == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
