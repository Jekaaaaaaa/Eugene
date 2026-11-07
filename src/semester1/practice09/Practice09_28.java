package semester1.practice09;

public class Practice09_28 {
    public static void main(String[] args) {
        AbstractSequence harmonic = new HarmonicSequence();
        AbstractSequence squares = new SquareNumbersSequence();
        System.out.println(harmonic + ": " + harmonic.sumFirstN(5));
        System.out.println(squares + ": " + squares.sumFirstN(5));
    }

    static abstract class AbstractSequence {
        private final String title;

        public AbstractSequence(String title) {
            this.title = title;
        }

        public abstract double getTerm(int index);

        public double sumFirstN(int n) {
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                sum += getTerm(i + 1);
            }
            return sum;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    static class HarmonicSequence extends AbstractSequence {
        public HarmonicSequence() {
            super("Гармонічна послідовність");
        }

        @Override
        public double getTerm(int index) {
            return 1.0 / index;
        }
    }

    static class SquareNumbersSequence extends AbstractSequence {
        public SquareNumbersSequence() {
            super("Послідовність квадратів");
        }

        @Override
        public double getTerm(int index) {
            return (double) index * index;
        }
    }
}
