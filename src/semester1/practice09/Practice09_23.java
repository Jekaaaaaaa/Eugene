package semester1.practice09;

public class Practice09_23 {
    public static void main(String[] args) {
        PassengerTrain train = new PassengerTrain("Київ — Львів", 3);
        train.attachCarriage(new TrainCarriage(1, "Купе", 36, 32));
        train.attachCarriage(new TrainCarriage(2, "Плацкарт", 54, 48));
        System.out.println(train);
        System.out.println("Купити 3 квитки у вагоні 1: " + train.bookTicketsInCarriage(1, 3));
        System.out.println("Купити ще 2: " + train.bookTicketsInCarriage(1, 2));
        System.out.println("Усього вільно: " + train.getTotalFreeSeats());
    }

    static class TrainCarriage {
        private final int carriageNumber;
        private final String type;
        private final int totalSeats;
        private int occupiedSeats;

        public TrainCarriage(int carriageNumber, String type, int totalSeats, int occupiedSeats) {
            this.carriageNumber = carriageNumber;
            this.type = type;
            this.totalSeats = totalSeats;
            this.occupiedSeats = occupiedSeats;
        }

        public int getCarriageNumber() {
            return carriageNumber;
        }

        public int getFreeSeats() {
            return totalSeats - occupiedSeats;
        }

        public boolean bookSeats(int count) {
            if (count <= 0 || count > getFreeSeats()) {
                return false;
            }
            occupiedSeats += count;
            return true;
        }
    }

    static class PassengerTrain {
        private final String route;
        private final TrainCarriage[] carriages;
        private int carriageCount;

        public PassengerTrain(String route, int capacity) {
            this.route = route;
            this.carriages = new TrainCarriage[capacity];
        }

        public void attachCarriage(TrainCarriage c) {
            if (c != null && carriageCount < carriages.length) {
                carriages[carriageCount++] = c;
            }
        }

        public int getTotalFreeSeats() {
            int seats = 0;
            for (int i = 0; i < carriageCount; i++) {
                seats += carriages[i].getFreeSeats();
            }
            return seats;
        }

        public boolean bookTicketsInCarriage(int carriageNumber, int seatsToBook) {
            for (int i = 0; i < carriageCount; i++) {
                if (carriages[i].getCarriageNumber() == carriageNumber) {
                    return carriages[i].bookSeats(seatsToBook);
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return route + ", вагонів: " + carriageCount;
        }
    }
}
