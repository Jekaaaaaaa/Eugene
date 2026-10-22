package semester1.practice06;

import java.util.Locale;

public class Practice06_15 {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.addSeconds(124);
        stopwatch.tick();
        stopwatch.displayTime();
    }

    static class Stopwatch {
        public int seconds;
    
        public void tick() {
            addSeconds(1);
        }
    
        public void addSeconds(int s) {
            if (s < 0 || (long) seconds + s > Integer.MAX_VALUE) {
                System.out.println("Некоректна кількість секунд.");
                return;
            }
            seconds += s;
        }
    
        public void displayTime() {
            System.out.printf("%02d:%02d%n", seconds / 60, seconds % 60);
        }
    }
}
