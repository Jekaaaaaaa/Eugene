package semester1.practice08;

public class Practice08_19 {
    public static void main(String[] args) {
        System.out.println(new Ticket("Концерт", 400.0));
        System.out.println(new StudentTicket("Концерт", 400.0, "ST-012"));
        System.out.println(new VipTicket("Концерт", 400.0, true, 250.0));
    }

    static class Ticket {
        private String eventName;
        private double basePrice;

        public Ticket(String eventName, double basePrice) {
            this.eventName = eventName;
            this.basePrice = basePrice;
        }

        public double getFinalPrice() {
            return basePrice;
        }

        @Override
        public String toString() {
            return eventName + ", ціна: " + getFinalPrice() + " грн";
        }
    }

    static class StudentTicket extends Ticket {
        private String studentCardNumber;

        public StudentTicket(String eventName, double basePrice, String studentCardNumber) {
            super(eventName, basePrice);
            this.studentCardNumber = studentCardNumber;
        }

        @Override
        public double getFinalPrice() {
            return super.getFinalPrice() * 0.5;
        }

        @Override
        public String toString() {
            return super.toString() + ", студентський: " + studentCardNumber;
        }
    }

    static class VipTicket extends Ticket {
        private boolean includesBackstage;
        private double loungeFee;

        public VipTicket(String eventName, double basePrice, boolean includesBackstage, double loungeFee) {
            super(eventName, basePrice);
            this.includesBackstage = includesBackstage;
            this.loungeFee = loungeFee;
        }

        @Override
        public double getFinalPrice() {
            return super.getFinalPrice() + loungeFee;
        }

        @Override
        public String toString() {
            return super.toString() + ", за лаштунки: " + (includesBackstage ? "так" : "ні");
        }
    }
}
