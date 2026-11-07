package semester1.practice08;

public class Practice08_32 {
    public static void main(String[] args) {
        ControlledSubstance adult = new ControlledSubstance("Препарат A", 120.0, false, "MD-10", 20);
        ControlledSubstance minor = new ControlledSubstance("Препарат A", 120.0, false, "MD-10", 16);
        ControlledSubstance expired = new ControlledSubstance("Препарат A", 120.0, true, "MD-10", 20);
        System.out.println(adult);
        System.out.println("Дорослому з рецептом: " + adult.canSell(true));
        System.out.println("Без рецепта: " + adult.canSell(false));
        System.out.println("Неповнолітньому: " + minor.canSell(true));
        System.out.println("Прострочений: " + expired.canSell(true));
    }

    static class Medicine {
        private String name;
        private double price;
        private boolean isExpired;

        public Medicine(String name, double price, boolean isExpired) {
            this.name = name;
            this.price = price;
            this.isExpired = isExpired;
        }

        public boolean isExpired() {
            return isExpired;
        }

        @Override
        public String toString() {
            return name + ", ціна: " + price + ", прострочений: " + isExpired;
        }
    }

    static class PrescriptionMedicine extends Medicine {
        private String doctorLicense;

        public PrescriptionMedicine(String name, double price, boolean isExpired, String doctorLicense) {
            super(name, price, isExpired);
            this.doctorLicense = doctorLicense;
        }

        public boolean canSell(boolean hasPrescription) {
            return !isExpired() && hasPrescription;
        }

        @Override
        public String toString() {
            return super.toString() + ", ліцензія: " + doctorLicense;
        }
    }

    static class ControlledSubstance extends PrescriptionMedicine {
        private int patientAge;

        public ControlledSubstance(String name, double price, boolean isExpired, String doctorLicense, int patientAge) {
            super(name, price, isExpired, doctorLicense);
            this.patientAge = patientAge;
        }

        @Override
        public boolean canSell(boolean hasPrescription) {
            return super.canSell(hasPrescription) && patientAge >= 18;
        }

        @Override
        public String toString() {
            return super.toString() + ", вік пацієнта: " + patientAge;
        }
    }
}
