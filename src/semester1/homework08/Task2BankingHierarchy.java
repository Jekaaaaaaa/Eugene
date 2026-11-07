package semester1.homework08;

import java.util.Locale;

public class Task2BankingHierarchy {
    public static void main(String[] args) {
        BankAccount current = new BankAccount("UA001", "Іван", 1000.0);
        current.deposit(300.0);
        System.out.println("Зняти 200 грн: " + current.withdraw(200.0));
        System.out.println(current);

        SavingsAccount savings = new SavingsAccount("UA101", "Олена Коваль", 5000.0, 12.0, 1000.0);
        System.out.println(savings);
        savings.withdraw(4500.0);
        savings.applyInterest();
        System.out.println(savings);

        CreditAccount credit = new CreditAccount("UA202", "Максим Бондар", 2000.0, 10000.0, 2.0);
        System.out.println(credit);
        System.out.println("Покупка на 5000 грн: " + credit.withdraw(5000.0));
        System.out.println(credit);
        credit.withdraw(8000.0);
    }

    static class BankAccount {
        private String iban;
        private String ownerName;
        protected double balance;

        public BankAccount(String iban, String ownerName, double initialBalance) {
            this.iban = iban;
            this.ownerName = ownerName;
            this.balance = initialBalance >= 0.0 && Double.isFinite(initialBalance) ? initialBalance : 0.0;
        }

        public String getIban() {
            return iban;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0.0 && Double.isFinite(balance + amount)) {
                balance += amount;
            }
        }

        public boolean withdraw(double amount) {
            if (!(amount > 0.0 && amount <= balance) || !Double.isFinite(amount)) {
                System.out.println("Відмова: некоректна сума або недостатньо коштів.");
                return false;
            }
            balance -= amount;
            return true;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "Рахунок[%s | Власник: %s | Баланс: %.2f грн]", iban, ownerName, balance);
        }
    }

    static class SavingsAccount extends BankAccount {
        private double interestRate;
        private double minBalance;

        public SavingsAccount(String iban, String ownerName, double initialBalance, double interestRate, double minBalance) {
            super(iban, ownerName, initialBalance);
            this.interestRate = interestRate;
            this.minBalance = minBalance;
        }

        @Override
        public boolean withdraw(double amount) {
            if (balance - amount < minBalance) {
                System.out.printf(Locale.ROOT, "Відмова: незнижуваний залишок %.2f грн.%n", minBalance);
                return false;
            }
            return super.withdraw(amount);
        }

        public void applyInterest() {
            deposit(balance * (interestRate / 100.0));
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "SavingsAccount{%s, Ставка: %.1f%%, Мін. залишок: %.2f грн}",
                    super.toString(), interestRate, minBalance);
        }
    }

    static class CreditAccount extends BankAccount {
        private double creditLimit;
        private double feePercent;

        public CreditAccount(String iban, String ownerName, double initialBalance, double creditLimit, double feePercent) {
            super(iban, ownerName, initialBalance);
            this.creditLimit = creditLimit;
            this.feePercent = feePercent;
        }

        @Override
        public boolean withdraw(double amount) {
            if (!(amount > 0.0) || !Double.isFinite(amount) || balance >= amount) {
                return super.withdraw(amount);
            }

            double borrowed = amount - Math.max(0.0, balance);
            double fee = borrowed * (feePercent / 100.0);
            double newBalance = balance - amount - fee;
            if (!(newBalance >= -creditLimit) || !Double.isFinite(newBalance)) {
                System.out.println("Відмова: перевищено кредитний ліміт.");
                return false;
            }
            balance = newBalance;
            return true;
        }

        public double getCurrentDebt() {
            return Math.max(0.0, -balance);
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "CreditAccount{%s, Ліміт: %.2f грн, Борг: %.2f грн}",
                    super.toString(), creditLimit, getCurrentDebt());
        }
    }
}
