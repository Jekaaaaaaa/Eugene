package semester1.practice08;

public class Practice08_29 {
    public static void main(String[] args) {
        ImmutableServerCredentials credentials = new ImmutableServerCredentials("localhost", 8443, "demo-key");
        System.out.println(credentials);
    }

    static final class ImmutableServerCredentials {
        private final String host;
        private final int port;
        private final String apiKey;

        public ImmutableServerCredentials(String host, int port, String apiKey) {
            this.host = host;
            this.port = port;
            this.apiKey = apiKey;
        }

        public String getHost() {
            return host;
        }

        public int getPort() {
            return port;
        }

        public String getApiKey() {
            return apiKey;
        }

        @Override
        public String toString() {
            return host + ":" + port + ", apiKey=***SECRET***";
        }
    }
}
