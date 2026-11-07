package semester1.practice07;

import java.util.Locale;

public class Practice07_30 {
    public static void main(String[] args) {
        System.out.println("Паліндром: " + StringUtils.isPalindrome("Я несу гусеня"));
        System.out.println("Навпаки: " + StringUtils.reverse("Java"));
        System.out.println("Голосних: " + StringUtils.countVowels("Україна"));
        System.out.println("Картка: " + StringUtils.maskCardNumber("1234 5678 9012 3456"));
    }

    static class StringUtils {
        private StringUtils() {
        }

        public static boolean isPalindrome(String s) {
            String normalized = s.replaceAll("(?U)\\s+", "").toLowerCase(Locale.ROOT);
            return normalized.equals(reverse(normalized));
        }

        public static String reverse(String s) {
            return new StringBuilder(s).reverse().toString();
        }

        public static int countVowels(String s) {
            String vowels = "aeiouаеєиіїоуюя";
            int count = 0;
            for (char letter : s.toLowerCase(Locale.ROOT).toCharArray()) {
                if (vowels.indexOf(letter) >= 0) {
                    count++;
                }
            }
            return count;
        }

        public static String maskCardNumber(String cardNumber) {
            char[] masked = cardNumber.toCharArray();
            int digits = 0;
            for (int i = masked.length - 1; i >= 0; i--) {
                if (Character.isDigit(masked[i])) {
                    digits++;
                    if (digits > 4) {
                        masked[i] = '*';
                    }
                }
            }
            return new String(masked);
        }
    }
}
