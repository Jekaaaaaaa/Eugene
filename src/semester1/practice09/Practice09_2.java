package semester1.practice09;

import java.util.Arrays;

public class Practice09_2 {
    public static void main(String[] args) {
        double[] original = {12.0, 14.5, 16.0};
        LabMeasurement measurement = new LabMeasurement("Нагрівання", original);
        original[0] = 99.0;
        System.out.println("Після зміни вхідного масиву: " + Arrays.toString(measurement.getSamples()));
        double[] copy = measurement.getSamples();
        copy[1] = 100.0;
        System.out.println("Після зміни копії з геттера: " + Arrays.toString(measurement.getSamples()));
    }

    static class LabMeasurement {
        private final String experimentName;
        private final double[] samples;

        public LabMeasurement(String experimentName, double[] samples) {
            this.experimentName = experimentName;
            this.samples = samples == null ? new double[0] : Arrays.copyOf(samples, samples.length);
        }

        public double[] getSamples() {
            return Arrays.copyOf(samples, samples.length);
        }

        @Override
        public String toString() {
            return experimentName + ": " + Arrays.toString(samples);
        }
    }
}
