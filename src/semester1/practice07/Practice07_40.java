package semester1.practice07;

public class Practice07_40 {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog(5);
        catalog.addBook(new BookItem("001", "Місто", "Валер'ян Підмогильний"));
        catalog.addBook(new BookItem("002", "Кобзар", "Тарас Шевченко"));
        catalog.addBook(new BookItem("003", "Лісова пісня", "Леся Українка"));
        catalog.printCatalog();

        System.out.println("Перша спроба взяти «Місто»: " + catalog.borrowBook("Місто"));
        catalog.printCatalog();
        System.out.println("Друга спроба взяти «Місто»: " + catalog.borrowBook("Місто"));
    }

    static class BookItem {
        private String isbn;
        private String title;
        private String author;
        private boolean isAvailable;

        public BookItem(String isbn, String title, String author) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public void borrowBook() {
            isAvailable = false;
        }

        public void returnBook() {
            isAvailable = true;
        }

        public void printBook() {
            System.out.println(isbn + " «" + title + "», " + author
                    + " — " + (isAvailable ? "доступна" : "видана"));
        }

        public String getTitle() {
            return title;
        }

        public boolean isAvailable() {
            return isAvailable;
        }
    }

    static class LibraryCatalog {
        private BookItem[] books;
        private int size;

        public LibraryCatalog(int capacity) {
            books = new BookItem[capacity];
        }

        public void addBook(BookItem book) {
            if (book != null && size < books.length) {
                books[size++] = book;
            }
        }

        public BookItem findBookByTitle(String title) {
            for (int i = 0; i < size; i++) {
                if (books[i].getTitle().equals(title)) {
                    return books[i];
                }
            }
            return null;
        }

        public boolean borrowBook(String title) {
            BookItem book = findBookByTitle(title);
            if (book == null || !book.isAvailable()) {
                return false;
            }
            book.borrowBook();
            return true;
        }

        public void printCatalog() {
            for (int i = 0; i < size; i++) {
                books[i].printBook();
            }
        }
    }
}
