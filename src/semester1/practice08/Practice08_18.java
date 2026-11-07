package semester1.practice08;

public class Practice08_18 {
    public static void main(String[] args) {
        System.out.println(new StandardTransfer(1000.0));
        System.out.println(new InternationalTransfer(1000.0, "PL"));
    }

    static class StandardTransfer {
        protected double amount;

        public StandardTransfer(double amount) {
            this.amount = amount;
        }

        public double getFee() {
            return amount * 0.01;
        }

        public double getTotalWithFee() {
            return amount + getFee();
        }

        @Override
        public String toString() {
            return "Сума: " + amount + ", комісія: " + getFee() + ", разом: " + getTotalWithFee();
        }
    }

    static class InternationalTransfer extends StandardTransfer {
        private String countryCode;

        public InternationalTransfer(double amount, String countryCode) {
            super(amount);
            this.countryCode = countryCode;
        }

        private static final double SWIFT_FEE = 15.0;

        @Override
        public double getFee() {
            return super.getFee() * 2.0 + SWIFT_FEE;
        }

        @Override
        public String toString() {
            return countryCode + ", " + super.toString();
        }
    }
}
