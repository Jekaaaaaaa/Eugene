package semester1.practice07;

import java.util.UUID;

public class Practice07_31 {
    public static void main(String[] args) {
        GameSession first = GameSession.createSession("Олена");
        GameSession.createSession("Іван");
        GameSession.createSession("Марія");
        GameSession fourth = GameSession.createSession("Андрій");
        System.out.println("Четверту сесію відхилено: " + (fourth == null));
        first.terminate();
        System.out.println("Слот звільнився: " + (GameSession.createSession("Андрій") != null));
    }

    static class GameSession {
        public static final int MAX_SESSIONS = 3;
        private static int activeSessionsCount = 0;
        private String sessionToken;
        private String hostPlayer;
        private boolean isActive;

        private GameSession(String host) {
            this.hostPlayer = host;
            this.sessionToken = UUID.randomUUID().toString();
            this.isActive = true;
        }

        public static GameSession createSession(String host) {
            if (activeSessionsCount >= MAX_SESSIONS) {
                System.out.println("Помилка: усі сервера перевантажені!");
                return null;
            }
            GameSession session = new GameSession(host);
            activeSessionsCount++;
            return session;
        }

        public void terminate() {
            if (isActive) {
                isActive = false;
                activeSessionsCount--;
            }
        }
    }
}
