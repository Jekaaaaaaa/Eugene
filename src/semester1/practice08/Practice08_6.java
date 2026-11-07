package semester1.practice08;

import java.util.Arrays;

public class Practice08_6 {
    public static void main(String[] args) {
        double[] temperatures = {12.5, 14.0, 18.5, 16.0};
        WeatherDay day = new WeatherDay("07.11.2026", temperatures);
        temperatures[0] = 99.0;
        System.out.println(day);
        System.out.println("Мінімум: " + day.getMinTemp() + ", максимум: " + day.getMaxTemp());
    }

    static class WeatherDay {
        private String date;
        private double[] hourlyTemps;

        public WeatherDay(String date, double[] hourlyTemps) {
            if (hourlyTemps.length == 0) {
                throw new IllegalArgumentException("Потрібен хоча б один вимір");
            }
            this.date = date;
            this.hourlyTemps = new double[hourlyTemps.length];
            for (int i = 0; i < hourlyTemps.length; i++) {
                this.hourlyTemps[i] = hourlyTemps[i];
            }
        }

        public double getMinTemp() {
            double min = hourlyTemps[0];
            for (double temp : hourlyTemps) {
                min = Math.min(min, temp);
            }
            return min;
        }

        public double getMaxTemp() {
            double max = hourlyTemps[0];
            for (double temp : hourlyTemps) {
                max = Math.max(max, temp);
            }
            return max;
        }

        public double getAverageTemp() {
            double sum = 0.0;
            for (double temp : hourlyTemps) {
                sum += temp;
            }
            return sum / hourlyTemps.length;
        }

        @Override
        public String toString() {
            return date + " " + Arrays.toString(hourlyTemps) + ", середня температура: " + getAverageTemp();
        }
    }
}
