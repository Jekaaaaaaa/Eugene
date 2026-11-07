package semester1.practice09;

public class Practice09_27 {
    public static void main(String[] args) {
        System.out.println(new SalariedEmployee(1, "Олена", 0.195, 20000.0, 3000.0));
        System.out.println(new HourlyContractor(2, "Іван", 0.195, 172, 150.0));
    }

    static abstract class AbstractEmployee {
        private final int id;
        private final String name;
        protected double taxRate;

        public AbstractEmployee(int id, String name, double taxRate) {
            this.id = id;
            this.name = name;
            this.taxRate = taxRate;
        }

        public abstract double calculateGrossSalary();

        public final double calculateNetSalary() {
            return calculateGrossSalary() * (1.0 - taxRate);
        }

        @Override
        public String toString() {
            return String.format("#%d %s, брутто: %.2f грн, нетто: %.2f грн", id, name,
                    calculateGrossSalary(), calculateNetSalary());
        }
    }

    static class SalariedEmployee extends AbstractEmployee {
        private double monthlySalary;
        private double bonus;

        public SalariedEmployee(int id, String name, double taxRate, double monthlySalary, double bonus) {
            super(id, name, taxRate);
            this.monthlySalary = monthlySalary;
            this.bonus = bonus;
        }

        @Override
        public double calculateGrossSalary() {
            return monthlySalary + bonus;
        }
    }

    static class HourlyContractor extends AbstractEmployee {
        private int hoursWorked;
        private double hourlyRate;

        public HourlyContractor(int id, String name, double taxRate, int hoursWorked, double hourlyRate) {
            super(id, name, taxRate);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateGrossSalary() {
            int regularHours = Math.min(hoursWorked, 160);
            int overtimeHours = Math.max(0, hoursWorked - 160);
            return hourlyRate * (regularHours + 1.5 * overtimeHours);
        }
    }
}
