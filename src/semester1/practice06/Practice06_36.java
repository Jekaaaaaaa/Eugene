package semester1.practice06;

import java.util.Locale;

public class Practice06_36 {
    public static void main(String[] args) {
        TemperatureTracker tracker = new TemperatureTracker();
        tracker.setTemps(new double[]{18, 20, 22, 21, 25, 24, 19});
        tracker.printWeeklyReport();
        System.out.println("Днів тепліше за 20 °C: " + tracker.countDaysAbove(20));
    }

    static class TemperatureTracker {
        private double[] dailyTemps = new double[7];
    
        public void setTemps(double[] temps) {
            if (temps == null || temps.length != 7) {
                System.out.println("Потрібно рівно 7 температур.");
                return;
            }
            for (double temperature : temps) {
                if (!Double.isFinite(temperature)) {
                    System.out.println("Температури мають бути скінченними числами.");
                    return;
                }
            }
            this.dailyTemps = temps.clone();
        }
    
        public int countDaysAbove(double threshold) {
            int count = 0;
            for (double temperature : dailyTemps) {
                if (temperature > threshold) {
                    count++;
                }
            }
            return count;
        }
    
        public void printWeeklyReport() {
            String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
            double max = dailyTemps[0];
            for (int i = 0; i < dailyTemps.length; i++) {
                System.out.println(days[i] + ": " + dailyTemps[i] + " °C");
                if (dailyTemps[i] > max) {
                    max = dailyTemps[i];
                }
            }
            System.out.print("Найтепліші дні: ");
            for (int i = 0; i < dailyTemps.length; i++) {
                if (dailyTemps[i] == max) {
                    System.out.print(days[i] + " ");
                }
            }
            System.out.println("(" + max + " °C)");
        }
    }
}
