package semester1.practice06;

import java.util.Locale;

public class Practice06_26 {
    public static void main(String[] args) {
        UserAccount account = new UserAccount();
        account.setCredentials("denys", "OldPass123");
        System.out.println("Вхід: " + account.login("denys", "OldPass123"));
        account.changePassword("wrong", "NewPass456");
        System.out.println("Старий пароль ще працює: " + account.login("denys", "OldPass123"));
        account.changePassword("OldPass123", "NewPass456");
        System.out.println("Новий пароль працює: " + account.login("denys", "NewPass456"));
        System.out.println("Старий пароль працює: " + account.login("denys", "OldPass123"));
    }

    static class UserAccount {
        private String username;
        private String password;
    
        public void setCredentials(String u, String p) {
            if (u == null || u.isBlank() || p == null || p.isBlank()) {
                System.out.println("Логін і пароль не можуть бути порожніми.");
                return;
            }
            this.username = u;
            this.password = p;
        }
    
        public boolean login(String enteredUser, String enteredPass) {
            return username != null && password != null
                    && username.equals(enteredUser) && password.equals(enteredPass);
        }
    
        public void changePassword(String oldPass, String newPass) {
            if (password != null && password.equals(oldPass)
                    && newPass != null && !newPass.isBlank()) {
                this.password = newPass;
                System.out.println("Пароль змінено.");
            } else {
                System.out.println("Пароль не змінено: неправильний старий або порожній новий пароль.");
            }
        }
    }
}
