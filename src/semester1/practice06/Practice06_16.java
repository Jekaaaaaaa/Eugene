package semester1.practice06;

import java.util.Locale;

public class Practice06_16 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.model = "HP LaserJet";
        printer.paperCount = 10;
        printer.printDocument("Звіт", 4);
        printer.printDocument("Книга", 20);
        System.out.println("Залишок паперу: " + printer.paperCount);
    }

    static class Printer {
        public String model;
        public int paperCount;
    
        public void printDocument(String title, int pages) {
            if (pages <= 0) {
                System.out.println("Кількість сторінок має бути додатною.");
            } else if (pages <= paperCount) {
                paperCount -= pages;
                System.out.println("Надруковано: " + title + " (" + pages + " стор.). Залишок паперу: " + paperCount);
            } else {
                System.out.println("Помилка: Недостатньо паперу в принтері " + model + "!");
            }
        }
    }
}
