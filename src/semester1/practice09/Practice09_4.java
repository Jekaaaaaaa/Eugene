package semester1.practice09;

public class Practice09_4 {
    public static void main(String[] args) {
        ClosedInterval interval = new ClosedInterval(8.0, 2.0);
        System.out.println(interval);
        System.out.println("Перетин з [8; 10]: " + interval.overlaps(new ClosedInterval(8.0, 10.0)));
        interval.resize(12.0, 11.0);
        System.out.println(interval);
    }

    static class ClosedInterval {
        private double start;
        private double end;

        public ClosedInterval(double start, double end) {
            resize(start, end);
        }

        public void resize(double newStart, double newEnd) {
            if (!Double.isFinite(newStart) || !Double.isFinite(newEnd)) {
                throw new IllegalArgumentException("Межі мають бути скінченними");
            }
            start = Math.min(newStart, newEnd);
            end = Math.max(newStart, newEnd);
        }

        public double getLength() {
            return end - start;
        }

        public double getMidpoint() {
            return start / 2.0 + end / 2.0;
        }

        public boolean overlaps(ClosedInterval other) {
            return start <= other.end && other.start <= end;
        }

        @Override
        public String toString() {
            return "[" + start + "; " + end + "] (центр: " + getMidpoint() + ", довжина: " + getLength() + ")";
        }
    }
}
