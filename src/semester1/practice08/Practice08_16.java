package semester1.practice08;

public class Practice08_16 {
    public static void main(String[] args) {
        System.out.println(new Gamer("Pixel", 70));
        System.out.println(new ProEsportsPlayer("Ace", 1400, "Storm", 12500.0, 5));
        System.out.println(new ProEsportsPlayer("Nova", 500, "Storm", 0.0, 0));
    }

    static class Gamer {
        private String nickname;
        private int hoursPlayed;

        public Gamer(String nickname, int hoursPlayed) {
            this.nickname = nickname;
            this.hoursPlayed = hoursPlayed;
        }

        @Override
        public String toString() {
            return nickname + ", зіграно: " + hoursPlayed + " год";
        }
    }

    static class ProEsportsPlayer extends Gamer {
        private String teamName;
        private double prizeMoneyUSD;
        private int tournamentsWon;

        public ProEsportsPlayer(String nickname, int hoursPlayed, String teamName, double prizeMoneyUSD, int tournamentsWon) {
            super(nickname, hoursPlayed);
            this.teamName = teamName;
            this.prizeMoneyUSD = prizeMoneyUSD;
            this.tournamentsWon = tournamentsWon;
        }

        public double getAveragePrizePerWin() {
            return tournamentsWon > 0 ? prizeMoneyUSD / tournamentsWon : 0.0;
        }

        @Override
        public String toString() {
            return super.toString() + ", команда: " + teamName + ", перемог: " + tournamentsWon
                    + ", у середньому: " + getAveragePrizePerWin() + " USD за перемогу";
        }
    }
}
