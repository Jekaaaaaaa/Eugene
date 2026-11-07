package semester1.practice09;

public class Practice09_13 {
    public static void main(String[] args) {
        BankAccount family = new BankAccount("UA-DEMO", 1000.0);
        PlasticCard first = new PlasticCard("0000000000000001", "12/28", family);
        PlasticCard second = new PlasticCard("0000000000000002", "12/29", family);
        family.deposit(200.0);
        System.out.println("Перша картка: " + first.payAtTerminal(300.0));
        System.out.println("Друга картка: " + second.payAtTerminal(400.0));
        second.setBlocked(true);
        System.out.println("Заблокована картка: " + second.payAtTerminal(100.0));
        System.out.println(family);
    }

    static class BankAccount {
        private final String iban;
        private double balance;

        public BankAccount(String iban, double balance) {
            this.iban = iban;
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0.0 && Double.isFinite(balance + amount)) {
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

        @Override
        public String toString() {
            return iban + ", залишок: " + balance + " грн";
        }
    }

    static class PlasticCard {
        private final String cardNumber;
        private final String expiryDate;
        private final BankAccount linkedAccount;

        public PlasticCard(String cardNumber, String expiryDate, BankAccount linkedAccount) {
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.linkedAccount = linkedAccount;
        }

        private boolean blocked;

        public void setBlocked(boolean blocked) {
            this.blocked = blocked;
        }

        public boolean payAtTerminal(double amount) {
            return !blocked && linkedAccount.withdraw(amount);
        }
    }
}
