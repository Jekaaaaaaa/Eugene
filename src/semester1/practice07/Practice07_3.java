package semester1.practice07;

public class Practice07_3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("UA123", "Іван", -50.0);
        account.deposit(800.0);
        System.out.println("Зняття 1000 грн: " + account.withdraw(1000.0));
        account.printAccount();
    }

    static class BankAccount {
        private String accountNumber;
        private String ownerName;
        private double balance;

        public BankAccount(String accountNumber, String ownerName, double initialBalance) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = initialBalance >= 0.0 ? initialBalance : 0.0;
        }

        public void deposit(double amount) {
            if (amount > 0.0 && Double.isFinite(amount)) {
                balance += amount;
            }
        }

        public boolean withdraw(double amount) {
            if (!(amount > 0.0 && amount <= balance) || !Double.isFinite(amount)) {
                return false;
            }
            balance -= amount;
            return true;
        }

        public void printAccount() {
            System.out.println(accountNumber + ", власник: " + ownerName + ", баланс: " + balance + " грн");
        }
    }
}
