package semester1.practice06;

import java.util.Locale;

public class Practice06_23 {
    public static void main(String[] args) {
        TextFormatter formatter = new TextFormatter();
        System.out.println(formatter.formatTitle("Україна"));
        System.out.println("Голосних: " + formatter.countVowels("Україна"));
    }

    static class TextFormatter {
        public String formatTitle(String text) {
            return "*** " + text.toUpperCase(java.util.Locale.ROOT) + " ***";
        }
    
        public int countVowels(String text) {
            String vowels = "аоуеиіяюєїaeiou";
            String lower = text.toLowerCase(java.util.Locale.ROOT);
            int count = 0;
            for (int i = 0; i < lower.length(); i++) {
                if (vowels.indexOf(lower.charAt(i)) >= 0) {
                    count++;
                }
            }
            return count;
        }
    }
}
