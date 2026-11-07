package semester1.practice09;

public class Practice09_36 {
    public static void main(String[] args) {
        AbstractAsset[] assets = {
                new GovernmentBond("BOND-A", 20000.0, 0.155),
                new DividendStock("STOCK-B", 15000.0, 0.08, 0.04, 0.195)
        };
        InvestmentPortfolio portfolio = new InvestmentPortfolio("Олена", assets);
        System.out.println(portfolio);
    }

    static abstract class AbstractAsset {
        private final String ticker;
        protected double investedAmount;

        public AbstractAsset(String ticker, double investedAmount) {
            this.ticker = ticker;
            this.investedAmount = investedAmount;
        }

        public abstract double calculateAnnualReturn();

        public double getInvestedAmount() {
            return investedAmount;
        }
    }

    static class GovernmentBond extends AbstractAsset {
        private double couponRate;

        public GovernmentBond(String ticker, double investedAmount, double couponRate) {
            super(ticker, investedAmount);
            this.couponRate = couponRate;
        }

        @Override
        public double calculateAnnualReturn() {
            return investedAmount * couponRate;
        }
    }

    static class DividendStock extends AbstractAsset {
        private double growthRate;
        private double dividendYield;
        private double dividendTaxRate;

        public DividendStock(String ticker, double investedAmount, double growthRate, double dividendYield, double dividendTaxRate) {
            super(ticker, investedAmount);
            this.growthRate = growthRate;
            this.dividendYield = dividendYield;
            this.dividendTaxRate = dividendTaxRate;
        }

        @Override
        public double calculateAnnualReturn() {
            return investedAmount * (growthRate + dividendYield * (1.0 - dividendTaxRate));
        }
    }

    static class InvestmentPortfolio {
        private final String investorName;
        private final AbstractAsset[] assets;

        public InvestmentPortfolio(String investorName, AbstractAsset[] assets) {
            this.investorName = investorName;
            this.assets = assets.clone();
        }

        public double getTotalValue() {
            double total = 0.0;
            for (AbstractAsset asset : assets) {
                total += asset.getInvestedAmount();
            }
            return total;
        }

        public double getExpectedAnnualReturn() {
            double profit = 0.0;
            for (AbstractAsset asset : assets) {
                profit += asset.calculateAnnualReturn();
            }
            return profit;
        }

        @Override
        public String toString() {
            return String.format("%s, вартість: %.2f грн, річний прибуток: %.2f грн",
                    investorName, getTotalValue(), getExpectedAnnualReturn());
        }
    }
}
