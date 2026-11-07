package semester1.practice09;

public class Practice09_15 {
    public static void main(String[] args) {
        ParcelOrder order = new ParcelOrder("P-18", 2.5, new DeliveryAddress("Київ", "Хрещатик", 1));
        System.out.println(order.changeDestination(new DeliveryAddress("Львів", "Городоцька", 4)));
        order.markAsShipped();
        System.out.println(order.changeDestination(new DeliveryAddress("Одеса", "Дерибасівська", 2)));
        System.out.println(order);
    }

    static class DeliveryAddress {
        private String city;
        private String street;
        private int postOfficeNumber;

        public DeliveryAddress(String city, String street, int postOfficeNumber) {
            if (!isValid(city, street, postOfficeNumber)) {
                throw new IllegalArgumentException("Некоректна адреса");
            }
            this.city = city;
            this.street = street;
            this.postOfficeNumber = postOfficeNumber;
        }

        private static boolean isValid(String city, String street, int office) {
            return city != null && !city.trim().isEmpty() && street != null && !street.trim().isEmpty() && office > 0;
        }

        @Override
        public String toString() {
            return city + ", вул. " + street + ", відділення " + postOfficeNumber;
        }
    }

    static class ParcelOrder {
        private final String orderId;
        private double weightKg;
        private DeliveryAddress destination;

        public ParcelOrder(String orderId, double weightKg, DeliveryAddress destination) {
            this.orderId = orderId;
            this.weightKg = weightKg;
            this.destination = destination;
        }

        private boolean shipped;

        public boolean changeDestination(DeliveryAddress newAddress) {
            if (shipped || newAddress == null) {
                return false;
            }
            destination = newAddress;
            return true;
        }

        public void markAsShipped() {
            shipped = true;
        }

        @Override
        public String toString() {
            return orderId + ", " + weightKg + " кг, " + destination + ", відправлено: " + shipped;
        }
    }
}
