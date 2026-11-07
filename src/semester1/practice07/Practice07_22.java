package semester1.practice07;

public class Practice07_22 {
    public static void main(String[] args) {
        DateService date = new DateService(15, 3, 2024);
        date.printDate();
        date.add(20);
        date.printDate();
        date.add(0, 3);
        date.printDate();
    }

    static class DateService {
        private int day;
        private int month;
        private int year;

        public DateService(int day, int month, int year) {
            if (day < 1 || day > 30 || month < 1 || month > 12) {
                throw new IllegalArgumentException("Некоректна дата");
            }
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public void add(int days) {
            add(days, 0);
        }

        public void add(int days, int months) {
            add(days, months, 0);
        }

        public void add(int days, int months, int years) {
            long dayIndex = (long) day - 1 + days;
            long monthIndex = (long) month - 1 + months + Math.floorDiv(dayIndex, 30L);
            int newYear = Math.toIntExact((long) year + years + Math.floorDiv(monthIndex, 12L));
            day = (int) Math.floorMod(dayIndex, 30L) + 1;
            month = (int) Math.floorMod(monthIndex, 12L) + 1;
            year = newYear;
        }

        public void printDate() {
            System.out.printf("%02d.%02d.%04d%n", day, month, year);
        }
    }
}
