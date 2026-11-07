package semester1.practice08;

public class Practice08_27 {
    public static void main(String[] args) {
        CashbackPlatinumCard card = new CashbackPlatinumCard("Іван", 3000.0, 1000.0, 5.0);
        System.out.println("Оплата 1500 грн: " + card.pay(1500.0));
        System.out.println("Оплата 800 грн: " + card.pay(800.0));
        System.out.println(card);
    }

    static class PaymentCard {
        private String cardHolder;
        protected double balance;

        public PaymentCard(String cardHolder, double balance) {
            this.cardHolder = cardHolder;
            this.balance = balance;
        }

        public boolean pay(double amount) {
            if (!(amount > 0.0 && amount <= balance) || !Double.isFinite(amount)) {
                return false;
            }
            balance -= amount;
            return true;
        }

        @Override
        public String toString() {
            return cardHolder + ", баланс: " + balance + " грн";
        }
    }

    static class DebitCard extends PaymentCard {
        private double dailyLimit;

        public DebitCard(String cardHolder, double balance, double dailyLimit) {
            super(cardHolder, balance);
            this.dailyLimit = dailyLimit;
        }

        @Override
        public boolean pay(double amount) {
            return amount <= dailyLimit && super.pay(amount);
        }
    }

    static class CashbackPlatinumCard extends DebitCard {
        private double cashbackPercent;

        public CashbackPlatinumCard(String cardHolder, double balance, double dailyLimit, double cashbackPercent) {
            super(cardHolder, balance, dailyLimit);
            this.cashbackPercent = cashbackPercent;
        }

        private double accumulatedCashback;

        @Override
        public boolean pay(double amount) {
            if (!super.pay(amount)) {
                return false;
            }
            accumulatedCashback += amount * cashbackPercent / 100.0;
            return true;
        }

        @Override
        public String toString() {
            return super.toString() + ", кешбек: " + accumulatedCashback + " грн";
        }
    }
}
