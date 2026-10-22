package semester1.practice06;

import java.util.Locale;

public class Practice06_22 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "Олена";
        employee.baseSalary = 30000;
        employee.bonusPercentage = 15;
        System.out.printf(Locale.US, "%s: зарплата %.2f грн, податки %.2f грн%n",
                employee.name, employee.calculateTotalSalary(), employee.calculateTax());
    }

    static class Employee {
        public String name;
        public double baseSalary;
        public double bonusPercentage;
    
        public double calculateTotalSalary() {
            return baseSalary * (1 + bonusPercentage / 100);
        }
    
        public double calculateTax() {
            return calculateTotalSalary() * 0.195;
        }
    }
}
