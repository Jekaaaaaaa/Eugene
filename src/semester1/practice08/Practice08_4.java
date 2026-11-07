package semester1.practice08;

import java.util.Locale;

public class Practice08_4 {
    public static void main(String[] args) {
        CardWallet wallet = new CardWallet("0000000000004589", "1234", 12500.0);
        System.out.println(wallet);
        System.out.println("Зміна PIN з неправильним кодом: " + wallet.changePin("1111", "5678"));
        System.out.println("Зміна PIN з правильним кодом: " + wallet.changePin("1234", "5678"));
    }

    static class CardWallet {
        private String cardNumber;
        private String pinCode;
        private double balance;

        public CardWallet(String cardNumber, String pinCode, double balance) {
            if (!cardNumber.matches("[0-9]{16}") || !pinCode.matches("[0-9]{4}")) {
                throw new IllegalArgumentException("Некоректний номер картки або PIN");
            }
            this.cardNumber = cardNumber;
            this.pinCode = pinCode;
            this.balance = balance;
        }

        public boolean changePin(String oldPin, String newPin) {
            if (!pinCode.equals(oldPin) || newPin == null || !newPin.matches("[0-9]{4}")) {
                return false;
            }
            pinCode = newPin;
            return true;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "CardWallet{card='**** **** **** %s', balance=%.2f UAH}",
                    cardNumber.substring(12), balance);
        }
    }
}
