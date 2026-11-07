package semester1.practice08;

public class Practice08_15 {
    public static void main(String[] args) {
        System.out.println(new PrintedBook("Місто", "Валер'ян Підмогильний", 1928, 304, "тверда"));
        System.out.println(new AudioBook("Місто", "Валер'ян Підмогильний", 1928, 495, "Олег"));
    }

    static class Publication {
        private String title;
        private String author;
        private int releaseYear;

        public Publication(String title, String author, int releaseYear) {
            this.title = title;
            this.author = author;
            this.releaseYear = releaseYear;
        }

        @Override
        public String toString() {
            return title + ", " + author + ", " + releaseYear;
        }
    }

    static class PrintedBook extends Publication {
        private int pageCount;
        private String coverType;

        public PrintedBook(String title, String author, int releaseYear, int pageCount, String coverType) {
            super(title, author, releaseYear);
            this.pageCount = pageCount;
            this.coverType = coverType;
        }

        @Override
        public String toString() {
            return super.toString() + ", сторінок: " + pageCount + ", обкладинка: " + coverType;
        }
    }

    static class AudioBook extends Publication {
        private int durationMinutes;
        private String narrator;

        public AudioBook(String title, String author, int releaseYear, int durationMinutes, String narrator) {
            super(title, author, releaseYear);
            this.durationMinutes = durationMinutes;
            this.narrator = narrator;
        }

        public String formatDuration() {
            return durationMinutes / 60 + " год " + durationMinutes % 60 + " хв";
        }

        @Override
        public String toString() {
            return super.toString() + ", " + formatDuration() + ", диктор: " + narrator;
        }
    }
}
