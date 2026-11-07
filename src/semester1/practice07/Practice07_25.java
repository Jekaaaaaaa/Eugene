package semester1.practice07;

public class Practice07_25 {
    public static void main(String[] args) {
        UserAccount first = new UserAccount("ivan", "ivan@example.com");
        UserAccount second = new UserAccount("maria", "maria@example.com");
        UserAccount third = new UserAccount("olena", "olena@example.com");
        first.printAccount();
        second.printAccount();
        third.printAccount();
        System.out.println("Наступний ID: " + UserAccount.getNextAvailableId());
    }

    static class UserAccount {
        private static int nextId = 1001;
        private int id;
        private String username;
        private String email;

        public UserAccount(String username, String email) {
            this.id = nextId++;
            this.username = username;
            this.email = email;
        }

        public static int getNextAvailableId() {
            return nextId;
        }

        public static void resetIdSequence(int startId) {
            nextId = startId;
        }

        public void printAccount() {
            System.out.println(id + ": " + username + " (" + email + ")");
        }
    }
}
