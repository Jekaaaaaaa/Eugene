package semester1.practice07;

import java.util.Locale;

public class Practice07_18 {
    public static void main(String[] args) {
        DocumentPrinter printer = new DocumentPrinter();
        printer.print("Звичайний текст");
        printer.print(123);
        printer.print(3.14159, 3);
        printer.print(new String[]{"Перший рядок", "Другий рядок"});
        printer.print("Великі літери", true);
    }

    static class DocumentPrinter {
        public void print(String message) {
            System.out.println(message);
        }

        public void print(int number) {
            print("[INT]: " + number);
        }

        public void print(double number, int decimals) {
            print(String.format("%." + Math.max(0, decimals) + "f", number));
        }

        public void print(String[] lines) {
            for (int i = 0; i < lines.length; i++) {
                print((i + 1) + ". " + lines[i]);
            }
        }

        public void print(String message, boolean uppercase) {
            print(uppercase ? message.toUpperCase(Locale.ROOT) : message);
        }
    }
}
