package semester1.practice07;

public class Practice07_20 {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log("Програму запущено");
        logger.log("WARN", "Мало вільної пам'яті");
        logger.log("ERROR", 404, "Файл не знайдено");
        logger.log("SAVE", "Дані збережено", true);
    }

    static class Logger {
        public void log(String message) {
            log("INFO", message);
        }

        public void log(String level, String message) {
            System.out.println("[" + level + "] " + message);
        }

        public void log(String level, int errorCode, String message) {
            log(level, "(Code: " + errorCode + "): " + message);
        }

        public void log(String tag, String message, boolean timestamp) {
            if (timestamp) {
                message = System.currentTimeMillis() + " " + message;
            }
            log(tag, message);
        }
    }
}
