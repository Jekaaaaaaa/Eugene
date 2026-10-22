package semester1.practice06;

import java.util.Locale;

public class Practice06_3 {
    public static void main(String[] args) {
        Book emptyBook = new Book();
        System.out.println(emptyBook.title + ", " + emptyBook.author + ", "
                + emptyBook.pages + ", " + emptyBook.isRead);
    }

    static class Book {
        public String title;
        public String author;
        public int pages;
        public boolean isRead;
    }
}
