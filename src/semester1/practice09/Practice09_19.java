package semester1.practice09;

public class Practice09_19 {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf("Проза", 3);
        shelf.putBook(new BookItem("Місто", "Валер'ян Підмогильний", 304));
        shelf.putBook(new BookItem("Тигролови", "Іван Багряний", 288));
        System.out.println("Найдовша книга: " + shelf.findLongestBook());
        System.out.println("Сторінок загалом: " + shelf.getTotalPagesOnShelf());
    }

    static class BookItem {
        private final String title;
        private final String author;
        private final int pages;

        public BookItem(String title, String author, int pages) {
            this.title = title;
            this.author = author;
            this.pages = pages;
        }

        public int getPages() {
            return pages;
        }

        @Override
        public String toString() {
            return title + ", " + author + ", " + pages + " с.";
        }
    }

    static class Bookshelf {
        private final String genre;
        private final BookItem[] books;
        private int bookCount;

        public Bookshelf(String genre, int capacity) {
            this.genre = genre;
            this.books = new BookItem[capacity];
        }

        public boolean putBook(BookItem book) {
            if (book == null || bookCount == books.length) {
                return false;
            }
            books[bookCount++] = book;
            return true;
        }

        public BookItem findLongestBook() {
            BookItem longest = null;
            for (int i = 0; i < bookCount; i++) {
                if (longest == null || books[i].getPages() > longest.getPages()) {
                    longest = books[i];
                }
            }
            return longest;
        }

        public int getTotalPagesOnShelf() {
            int total = 0;
            for (int i = 0; i < bookCount; i++) {
                total += books[i].getPages();
            }
            return total;
        }
    }
}
