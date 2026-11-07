package semester1.practice07;

public class Practice07_26 {
    public static void main(String[] args) {
        for (int user = 1; user <= 6; user++) {
            boolean connected = ServerConfig.connect();
            System.out.println("Користувач " + user + ": " + (connected ? "підключено" : "відмовлено"));
        }
        ServerConfig.printServerStatus();
        ServerConfig.disconnect();
        ServerConfig.printServerStatus();
    }

    static class ServerConfig {
        public static final String SERVER_NAME = "AlphaEnterprise";
        public static final int MAX_CONNECTIONS = 5;
        private static int activeConnections = 0;

        public static boolean connect() {
            if (activeConnections >= MAX_CONNECTIONS) {
                return false;
            }
            activeConnections++;
            return true;
        }

        public static void disconnect() {
            if (activeConnections > 0) {
                activeConnections--;
            }
        }

        public static void printServerStatus() {
            System.out.println(SERVER_NAME + ", активних: " + activeConnections
                    + ", вільних: " + (MAX_CONNECTIONS - activeConnections));
        }
    }
}
