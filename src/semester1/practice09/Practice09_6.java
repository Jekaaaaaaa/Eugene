package semester1.practice09;

public class Practice09_6 {
    public static void main(String[] args) {
        HighSecuritySafe safe = new HighSecuritySafe(1234, 500.0);
        System.out.println("Поповнення: " + safe.putCash(1234, 100.0));
        System.out.println("Зняття: " + safe.takeCash(1234, 250.0));
        for (int attempt = 0; attempt < 3; attempt++) {
            System.out.println("Хибний PIN: " + safe.takeCash(1111, 10.0));
        }
        System.out.println("Після блокування: " + safe.takeCash(1234, 10.0));
    }

    static class HighSecuritySafe {
        private int pinCode;
        private double storedCash;

        public HighSecuritySafe(int pinCode, double storedCash) {
            this.pinCode = pinCode;
            this.storedCash = storedCash;
        }

        private int failedAttempts;
        private boolean permanentlyBlocked;

        private boolean checkAccess(int enteredPin) {
            if (permanentlyBlocked) {
                return false;
            }
            if (enteredPin != pinCode) {
                failedAttempts++;
                permanentlyBlocked = failedAttempts >= 3;
                return false;
            }
            failedAttempts = 0;
            return true;
        }

        public boolean putCash(int pin, double amount) {
            if (!checkAccess(pin) || !(amount > 0.0) || !Double.isFinite(storedCash + amount)) {
                return false;
            }
            storedCash += amount;
            return true;
        }

        public boolean takeCash(int pin, double amount) {
            if (!checkAccess(pin) || !(amount > 0.0 && amount <= storedCash) || !Double.isFinite(amount)) {
                return false;
            }
            storedCash -= amount;
            return true;
        }
    }
}
