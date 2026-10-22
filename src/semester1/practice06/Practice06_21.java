package semester1.practice06;

import java.util.Locale;

public class Practice06_21 {
    public static void main(String[] args) {
        CurrencyExchange exchange = new CurrencyExchange();
        exchange.usdRate = 41.5;
        double usd = exchange.toUSD(10000);
        System.out.printf(Locale.US, "10000.00 грн = %.2f USD; назад: %.2f грн%n", usd, exchange.toUAH(usd));
    }

    static class CurrencyExchange {
        public double usdRate = 41.5;
    
        public double toUSD(double uah) {
            if (!Double.isFinite(usdRate) || usdRate <= 0) {
                System.out.println("Некоректний курс долара.");
                return 0.0;
            }
            return uah / usdRate;
        }
    
        public double toUAH(double usd) {
            if (!Double.isFinite(usdRate) || usdRate <= 0) {
                System.out.println("Некоректний курс долара.");
                return 0.0;
            }
            return usd * usdRate;
        }
    }
}
