package semester1.practice08;

public class Practice08_17 {
    public static void main(String[] args) {
        System.out.println(new StaffMember("Іван", 18000.0));
        System.out.println(new Manager("Олена", 28000.0, 5000.0));
        System.out.println(new SalesPerson("Марія", 18000.0, 90000.0, 5.0));
    }

    static class StaffMember {
        private String name;
        private double baseSalary;

        public StaffMember(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public double calculateMonthlyPay() {
            return baseSalary;
        }

        @Override
        public String toString() {
            return name + ", ставка: " + baseSalary + ", до виплати: " + calculateMonthlyPay();
        }
    }

    static class Manager extends StaffMember {
        private double teamBonus;

        public Manager(String name, double baseSalary, double teamBonus) {
            super(name, baseSalary);
            this.teamBonus = teamBonus;
        }

        @Override
        public double calculateMonthlyPay() {
            return super.calculateMonthlyPay() + teamBonus;
        }

        @Override
        public String toString() {
            return "Менеджер: " + super.toString();
        }
    }

    static class SalesPerson extends StaffMember {
        private double salesVolume;
        private double commissionRate;

        public SalesPerson(String name, double baseSalary, double salesVolume, double commissionRate) {
            super(name, baseSalary);
            this.salesVolume = salesVolume;
            this.commissionRate = commissionRate;
        }

        @Override
        public double calculateMonthlyPay() {
            return super.calculateMonthlyPay() + salesVolume * (commissionRate / 100.0);
        }

        @Override
        public String toString() {
            return "Продавець: " + super.toString();
        }
    }
}
