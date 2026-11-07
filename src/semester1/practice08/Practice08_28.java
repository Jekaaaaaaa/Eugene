package semester1.practice08;

import java.util.Locale;

public class Practice08_28 {
    public static void main(String[] args) {
        CustomTerminal terminal = new CustomTerminal();
        System.out.println(terminal.getWelcomeBanner());
        System.out.println(terminal.generateAuthHash("operator"));
    }

    static class SecurityTerminal {
        public final String generateAuthHash(String user) {
            return "AUTH-SHA-" + user.toUpperCase(Locale.ROOT);
        }

        public String getWelcomeBanner() {
            return "Вітаємо";
        }
    }

    static class CustomTerminal extends SecurityTerminal {
        // Компілятор забороняє перевизначати generateAuthHash, бо метод оголошено final.
        @Override
        public String getWelcomeBanner() {
            return "Термінал оператора";
        }
    }
}
