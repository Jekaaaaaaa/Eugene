package semester1.practice09;

public class Practice09_29 {
    public static void main(String[] args) {
        System.out.println(new DomesticTransfer("UA-12", 400.0));
        System.out.println(new DomesticTransfer("UA-13", 2000.0));
        System.out.println(new CryptoTransfer("BTC-01", 50.0, 0.8));
    }

    static abstract class AbstractTransaction {
        private final String txId;
        protected final double amount;

        public AbstractTransaction(String txId, double amount) {
            this.txId = txId;
            this.amount = amount;
        }

        public abstract double calculateCommission();

        public final double getTotalDebit() {
            return amount + calculateCommission();
        }

        @Override
        public String toString() {
            return txId + ", комісія: " + calculateCommission() + ", списання: " + getTotalDebit();
        }
    }

    static class DomesticTransfer extends AbstractTransaction {
        public DomesticTransfer(String txId, double amount) {
            super(txId, amount);
        }

        @Override
        public double calculateCommission() {
            return Math.max(5.0, amount * 0.005);
        }
    }

    static class CryptoTransfer extends AbstractTransaction {
        private double networkGasFee;

        public CryptoTransfer(String txId, double amount, double networkGasFee) {
            super(txId, amount);
            this.networkGasFee = networkGasFee;
        }

        @Override
        public double calculateCommission() {
            return networkGasFee;
        }
    }
}
