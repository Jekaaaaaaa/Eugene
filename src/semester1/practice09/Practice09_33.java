package semester1.practice09;

public class Practice09_33 {
    public static void main(String[] args) {
        AbstractPcPart[] parts = {
                new ProcessorPart("Ryzen", 8000.0, 8, 105),
                new VideoCardPart("Radeon", 15000.0, 12, 230)
        };
        DesktopPC pc = new DesktopPC(500, parts);
        System.out.println("Споживання: " + pc.getTotalPowerWatts() + " Вт");
        System.out.println("БЖ 500 Вт має запас: " + pc.isStable());
        System.out.println("БЖ 350 Вт має запас: " + new DesktopPC(350, parts).isStable());
    }

    static abstract class AbstractPcPart {
        private final String model;
        private final double priceUah;

        public AbstractPcPart(String model, double priceUah) {
            this.model = model;
            this.priceUah = priceUah;
        }

        public abstract int getPowerConsumptionWatts();
    }

    static class ProcessorPart extends AbstractPcPart {
        private int cores;
        private int watts;

        public ProcessorPart(String model, double priceUah, int cores, int watts) {
            super(model, priceUah);
            this.cores = cores;
            this.watts = watts;
        }

        @Override
        public int getPowerConsumptionWatts() {
            return watts;
        }
    }

    static class VideoCardPart extends AbstractPcPart {
        private int vramGb;
        private int watts;

        public VideoCardPart(String model, double priceUah, int vramGb, int watts) {
            super(model, priceUah);
            this.vramGb = vramGb;
            this.watts = watts;
        }

        @Override
        public int getPowerConsumptionWatts() {
            return watts;
        }
    }

    static class DesktopPC {
        private final int psuMaxWatts;
        private final AbstractPcPart[] parts;

        public DesktopPC(int psuMaxWatts, AbstractPcPart[] parts) {
            this.psuMaxWatts = psuMaxWatts;
            this.parts = parts.clone();
        }

        public long getTotalPowerWatts() {
            long total = 0;
            for (AbstractPcPart part : parts) {
                total += part.getPowerConsumptionWatts();
            }
            return total;
        }

        public boolean isStable() {
            return psuMaxWatts * 5L >= getTotalPowerWatts() * 6L;
        }
    }
}
