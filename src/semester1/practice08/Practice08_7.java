package semester1.practice08;

public class Practice08_7 {
    public static void main(String[] args) {
        IntRange range = new IntRange(10, 3);
        System.out.println(range);
        System.out.println("Містить 5: " + range.contains(5));
        range.setBounds(20, 15);
        System.out.println(range);
    }

    static class IntRange {
        private int min;
        private int max;

        public IntRange(int min, int max) {
            setBounds(min, max);
        }

        public void setBounds(int min, int max) {
            this.min = Math.min(min, max);
            this.max = Math.max(min, max);
        }

        public boolean contains(int value) {
            return value >= min && value <= max;
        }

        public int getLength() {
            return Math.subtractExact(max, min);
        }

        @Override
        public String toString() {
            return "[" + min + " .. " + max + "] (довжина: " + getLength() + ")";
        }
    }
}
