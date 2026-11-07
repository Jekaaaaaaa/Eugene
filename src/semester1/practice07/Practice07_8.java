package semester1.practice07;

public class Practice07_8 {
    public static void main(String[] args) {
        Employee employee = new Employee(17, "Олена Бойко", "Інженер", 20000.0);
        employee.printBadge();
        employee.raiseSalary(15.0);
        System.out.printf("Річний дохід після підвищення: %.2f грн%n", employee.getAnnualSalary());
    }

    static class Employee {
        private int id;
        private String fullName;
        private String position;
        private double monthlySalary;

        public Employee(int id, String fullName, String position, double monthlySalary) {
            this.id = id;
            this.fullName = fullName;
            this.position = position;
            this.monthlySalary = monthlySalary;
        }

        public void raiseSalary(double percent) {
            if (percent > 0.0 && Double.isFinite(percent)) {
                monthlySalary += monthlySalary * percent / 100.0;
            }
        }

        public double getAnnualSalary() {
            return 12.0 * monthlySalary;
        }

        public void printBadge() {
            System.out.println("#" + id + " " + fullName + ", " + position + ", " + monthlySalary + " грн/міс.");
        }
    }
}
