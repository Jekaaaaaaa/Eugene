package semester1.practice06;

import java.util.Locale;

public class Practice06_27 {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();
        bank.setAccountNumber("UA001");
        bank.deposit(1000);
        System.out.println("Спроба зняти 1500: " + bank.withdraw(1500));
        System.out.println("Баланс після відмови: " + bank.getBalance());
        System.out.println("Зняття 300: " + bank.withdraw(300));
        System.out.println(bank.getAccountNumber() + ": " + bank.getBalance() + " грн");
    }

    static class BankAccount {
        private String accountNumber;
        private double balance;
    
        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }
    
        public void deposit(double amount) {
            if (Double.isFinite(amount) && amount > 0 && Double.isFinite(balance + amount)) {
                balance += amount;
            } else {
                System.out.println("Некоректна сума поповнення.");
            }
        }
    
        public boolean withdraw(double amount) {
            if (!Double.isFinite(amount) || amount <= 0 || amount > balance) {
                System.out.println("Зняття відхилено: некоректна сума або недостатньо коштів.");
                return false;
            }
            balance -= amount;
            return true;
        }
    
        public double getBalance() {
            return balance;
        }
    
        public String getAccountNumber() {
            return accountNumber;
        }
    }
}
