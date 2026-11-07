package semester1.practice09;

public class Practice09_3 {
    public static void main(String[] args) {
        CryptoVault vault = new CryptoVault("demo-wallet", "навчальна фраза", 2.0);
        System.out.println("Переказ заблоковано: " + !vault.sendBtc(0.5, "demo-destination"));
        System.out.println("Розблоковано: " + vault.unlock("навчальна фраза"));
        System.out.println("Надіслано: " + vault.sendBtc(0.5, "demo-destination"));
        vault.lock();
        System.out.println(vault);
    }

    static class CryptoVault {
        private final String walletAddress;
        private String secretRecoveryPhrase;
        private double btcBalance;

        public CryptoVault(String walletAddress, String secretRecoveryPhrase, double btcBalance) {
            this.walletAddress = walletAddress;
            this.secretRecoveryPhrase = secretRecoveryPhrase;
            this.btcBalance = btcBalance;
        }

        private boolean locked = true;

        public boolean unlock(String phrase) {
            if (!secretRecoveryPhrase.equals(phrase)) {
                return false;
            }
            locked = false;
            return true;
        }

        public void lock() {
            locked = true;
        }

        public boolean sendBtc(double amount, String destination) {
            if (locked || !(amount > 0.0 && amount <= btcBalance) || !Double.isFinite(amount)
                    || destination == null || destination.trim().isEmpty()) {
                return false;
            }
            btcBalance -= amount;
            return true;
        }

        @Override
        public String toString() {
            return walletAddress + ", заблоковано: " + locked + ", баланс: " + btcBalance + " BTC";
        }
    }
}
