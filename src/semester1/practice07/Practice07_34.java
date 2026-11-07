package semester1.practice07;

public class Practice07_34 {
    public static void main(String[] args) {
        ClientAccount ivan = new ClientAccount("UA001", "Іван", 10000.0);
        ClientAccount maria = new ClientAccount("UA002", "Марія", 2000.0);
        System.out.println("Переказ 3500 грн: " + ivan.transferTo(maria, 3500.0));
        ivan.printAccount();
        maria.printAccount();
    }

    static class ClientAccount {
        private String iban;
        private String owner;
        private double balance;

        public ClientAccount(String iban, String owner, double balance) {
            this.iban = iban;
            this.owner = owner;
            this.balance = balance;
        }

        public boolean transferTo(ClientAccount recipient, double amount) {
            if (recipient == null || recipient == this || !(amount > 0.0 && amount <= balance)
                    || !Double.isFinite(recipient.balance + amount)) {
                return false;
            }
            balance -= amount;
            recipient.balance += amount;
            return true;
        }

        public void printAccount() {
            System.out.println(iban + ", " + owner + ", баланс: " + balance + " грн");
        }
    }
}
