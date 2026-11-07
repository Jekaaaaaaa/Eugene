package semester1.practice09;

import java.util.Arrays;

public class Practice09_39 {
    public static void main(String[] args) {
        double[] signal = {0.2, 0.7, -0.9, 0.4};
        SignalProcessor processor = new SignalProcessor(new AbstractFilter[]{new AmplifierFilter(2.0), new ClippingFilter(1.0)});
        System.out.println("Результат: " + Arrays.toString(processor.process(signal)));
        System.out.println("Вхід: " + Arrays.toString(signal));
    }

    static abstract class AbstractFilter {
        private final String filterName;

        public AbstractFilter(String filterName) {
            this.filterName = filterName;
        }

        public abstract double processSample(double x);

        @Override
        public String toString() {
            return filterName;
        }
    }

    static class AmplifierFilter extends AbstractFilter {
        private double gain;

        public AmplifierFilter(double gain) {
            super("Підсилювач");
            this.gain = gain;
        }

        @Override
        public double processSample(double x) {
            return x * gain;
        }
    }

    static class ClippingFilter extends AbstractFilter {
        private double threshold;

        public ClippingFilter(double threshold) {
            super("Обмежувач");
            if (!(threshold >= 0.0) || !Double.isFinite(threshold)) {
                throw new IllegalArgumentException("Поріг має бути невід'ємним і скінченним");
            }
            this.threshold = threshold;
        }

        @Override
        public double processSample(double x) {
            return Math.max(-threshold, Math.min(threshold, x));
        }
    }

    static class SignalProcessor {
        private final AbstractFilter[] pipeline;

        public SignalProcessor(AbstractFilter[] pipeline) {
            this.pipeline = pipeline.clone();
        }

        public double[] process(double[] signal) {
            double[] output = signal.clone();
            for (AbstractFilter filter : pipeline) {
                for (int i = 0; i < output.length; i++) {
                    output[i] = filter.processSample(output[i]);
                }
            }
            return output;
        }
    }
}
