package semester1.practice07;

public class Practice07_10 {
    public static void main(String[] args) {
        new Fraction().print();
        new Fraction(5).print();
        Fraction fraction = new Fraction(6, -8);
        fraction.print();
        System.out.println("Десяткове значення: " + fraction.toDouble());
        new Fraction(3, 0).print();
    }

    static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                System.out.println("Помилка: знаменник не може дорівнювати нулю.");
                denominator = 1;
            }
            long num = numerator;
            long den = denominator;
            if (den < 0) {
                num = -num;
                den = -den;
            }
            long divisor = gcd(Math.abs(num), den);
            this.numerator = Math.toIntExact(num / divisor);
            this.denominator = Math.toIntExact(den / divisor);
        }

        public Fraction(int wholeNumber) {
            this(wholeNumber, 1);
        }

        public Fraction() {
            this(0, 1);
        }

        private long gcd(long a, long b) {
            while (b != 0) {
                long remainder = a % b;
                a = b;
                b = remainder;
            }
            return a;
        }

        public void print() {
            System.out.println(denominator == 1 ? String.valueOf(numerator) : numerator + "/" + denominator);
        }

        public double toDouble() {
            return (double) numerator / denominator;
        }
    }
}
