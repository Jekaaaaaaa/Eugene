package semester1.practice07;

import java.util.Locale;

public class Practice07_6 {
    public static void main(String[] args) {
        Time time = new Time(23, 59, 59);
        System.out.println(time.toUniversalString() + " / " + time.toStandardString());
        time.tick();
        System.out.println(time.toUniversalString() + " / " + time.toStandardString());
    }

    static class Time {
        private int hours;
        private int minutes;
        private int seconds;

        public Time(int hours, int minutes, int seconds) {
            this.hours = hours >= 0 && hours <= 23 ? hours : 0;
            this.minutes = minutes >= 0 && minutes <= 59 ? minutes : 0;
            this.seconds = seconds >= 0 && seconds <= 59 ? seconds : 0;
        }

        public void tick() {
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
                if (minutes == 60) {
                    minutes = 0;
                    hours = (hours + 1) % 24;
                }
            }
        }

        public String toUniversalString() {
            return String.format(Locale.ROOT, "%02d:%02d:%02d", hours, minutes, seconds);
        }

        public String toStandardString() {
            int hour = hours % 12 == 0 ? 12 : hours % 12;
            String period = hours < 12 ? "AM" : "PM";
            return String.format(Locale.ROOT, "%d:%02d:%02d %s", hour, minutes, seconds, period);
        }
    }
}
