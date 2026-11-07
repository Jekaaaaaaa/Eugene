package semester1.practice08;

public class Practice08_37 {
    public static void main(String[] args) {
        VipCinemaHall hall = new VipCinemaHall("Зал 1", 3, 4, 120.0, 50.0);
        hall.bookSeat(0, 1);
        hall.bookSeat(2, 2);
        System.out.println("Повторне бронювання: " + hall.bookSeat(2, 2));
        System.out.println(hall);
        System.out.println("Зайнято: " + hall.getOccupiedCount() + ", виручка: " + hall.calculateRevenue() + " грн");
    }

    static class CinemaHall {
        private String hallName;
        protected boolean[][] seats;
        protected double baseTicketPrice;

        public CinemaHall(String hallName, int rows, int columns, double baseTicketPrice) {
            if (rows <= 0 || columns <= 0) {
                throw new IllegalArgumentException("Зал повинен мати ряди та місця");
            }
            this.hallName = hallName;
            this.seats = new boolean[rows][columns];
            this.baseTicketPrice = baseTicketPrice;
        }

        public boolean bookSeat(int row, int col) {
            if (row < 0 || row >= seats.length || col < 0 || col >= seats[row].length || seats[row][col]) {
                return false;
            }
            seats[row][col] = true;
            return true;
        }

        public int getOccupiedCount() {
            int count = 0;
            for (boolean[] row : seats) {
                for (boolean occupied : row) {
                    if (occupied) {
                        count++;
                    }
                }
            }
            return count;
        }

        public double calculateRevenue() {
            return getOccupiedCount() * baseTicketPrice;
        }

        @Override
        public String toString() {
            StringBuilder plan = new StringBuilder(hallName);
            for (boolean[] row : seats) {
                plan.append(System.lineSeparator());
                for (boolean occupied : row) {
                    plan.append(occupied ? "[X]" : "[O]");
                }
            }
            return plan.toString();
        }
    }

    static class VipCinemaHall extends CinemaHall {
        private double complimentaryBarCost;

        public VipCinemaHall(String hallName, int rows, int columns, double baseTicketPrice, double complimentaryBarCost) {
            super(hallName, rows, columns, baseTicketPrice);
            this.complimentaryBarCost = complimentaryBarCost;
        }

        @Override
        public double calculateRevenue() {
            double revenue = super.calculateRevenue();
            for (boolean occupied : seats[seats.length - 1]) {
                if (occupied) {
                    revenue += complimentaryBarCost;
                }
            }
            return revenue;
        }
    }
}
