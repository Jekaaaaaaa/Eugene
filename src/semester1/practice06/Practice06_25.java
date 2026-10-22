package semester1.practice06;

import java.util.Locale;

public class Practice06_25 {
    public static void main(String[] args) {
        SecretVault vault = new SecretVault();
        // vault.secretCode = "hacked"; // Помилка компілятора: secretCode has private access in SecretVault.
        System.out.println("Правильний код: " + vault.verifyCode("Pass123"));
        System.out.println("Неправильний код: " + vault.verifyCode("hacked"));
    }

    static class SecretVault {
        private String secretCode = "Pass123";
    
        public boolean verifyCode(String attempt) {
            return secretCode.equals(attempt);
        }
    }
}
