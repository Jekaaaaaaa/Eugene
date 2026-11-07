package semester1.practice07;

public class Practice07_23 {
    public static void main(String[] args) {
        SalaryCalculator calculator = new SalaryCalculator();
        System.out.printf("Ставка: %.2f грн%n", calculator.calculate(20000.0));
        System.out.printf("З фіксованою премією: %.2f грн%n", calculator.calculate(20000.0, 2500.0));
        System.out.printf("З бонусом після податку: %.2f грн%n", calculator.calculate(20000.0, 10.0, true));
        System.out.printf("З понаднормовими: %.2f грн%n", calculator.calculate(20000.0, 8, 180.0));
    }

    static class SalaryCalculator {
        public double calculate(double baseRate) {
            return baseRate;
        }

        public double calculate(double baseRate, double fixedBonus) {
            return baseRate + fixedBonus;
        }

        public double calculate(double baseRate, double bonusPercent, boolean isTaxDeducted) {
            double grossSalary = calculate(baseRate, baseRate * bonusPercent / 100.0);
            return isTaxDeducted ? grossSalary * 0.805 : grossSalary;
        }

        public double calculate(double baseRate, int overtimeHours, double overtimeHourlyRate) {
            return calculate(baseRate, overtimeHours * overtimeHourlyRate);
        }
    }
}
