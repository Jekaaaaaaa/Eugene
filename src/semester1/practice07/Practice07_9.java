package semester1.practice07;

public class Practice07_9 {
    public static void main(String[] args) {
        new User().printProfile();
        new User("olena").printProfile();
        new User("andrii", "andrii@example.com").printProfile();
        new User("admin", "admin@example.com", "ADMIN", false).printProfile();
    }

    static class User {
        private String login;
        private String email;
        private String role;
        private boolean isActive;

        public User(String login, String email, String role, boolean isActive) {
            this.login = login;
            this.email = email;
            this.role = role;
            this.isActive = isActive;
        }

        public User(String login, String email) {
            this(login, email, "USER", true);
        }

        public User(String login) {
            this(login, login + "@domain.com");
        }

        public User() {
            this("guest");
        }

        public void printProfile() {
            System.out.println(login + ", " + email + ", роль: " + role + ", активний: " + isActive);
        }
    }
}
