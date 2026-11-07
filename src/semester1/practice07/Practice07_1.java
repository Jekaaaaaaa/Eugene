package semester1.practice07;

public class Practice07_1 {
    public static void main(String[] args) {
        Book first = new Book();
        Book second = new Book("Місто", "Валер'ян Підмогильний", 1928, 320.0);
        first.printInfo();
        second.printInfo();
    }

    static class Book {
        private String title;
        private String author;
        private int year;
        private double price;

        public Book() {
            this("Невідомо", "Невідомий", 2000, 0.0);
        }

        public Book(String title, String author, int year, double price) {
            this.title = title;
            this.author = author;
            this.year = year < 0 ? 2000 : year;
            this.price = price >= 0.0 ? price : 0.0;
        }

        public void printInfo() {
            System.out.println(title + ", " + author + ", " + year + ", " + price + " грн");
        }
    }
}
