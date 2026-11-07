package semester1.practice07;

public class Practice07_28 {
    public static void main(String[] args) {
        System.out.println("100 USD = " + CurrencyExchange.usdToUah(100.0) + " грн");
        System.out.println("100 EUR = " + CurrencyExchange.eurToUah(100.0) + " грн");
        System.out.println("4150 грн = " + CurrencyExchange.uahToUsd(4150.0) + " USD");
        CurrencyExchange.updateRates(42.0, 46.0);
        System.out.println("За новим курсом 100 USD = " + CurrencyExchange.usdToUah(100.0) + " грн");
    }

    static class CurrencyExchange {
        private static double usdToUahRate = 41.5;
        private static double eurToUahRate = 45.2;

        public static void updateRates(double newUsd, double newEur) {
            if (newUsd > 0.0 && newEur > 0.0 && Double.isFinite(newUsd) && Double.isFinite(newEur)) {
                usdToUahRate = newUsd;
                eurToUahRate = newEur;
            }
        }

        public static double uahToUsd(double uah) {
            return uah / usdToUahRate;
        }

        public static double usdToUah(double usd) {
            return usd * usdToUahRate;
        }

        public static double eurToUah(double eur) {
            return eur * eurToUahRate;
        }
    }
}
