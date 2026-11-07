package semester1.homework09;

import java.util.Arrays;
import java.util.Locale;

public class Task2WorkstationConfigurator {
    public static void main(String[] args) {
        Motherboard motherboard = new Motherboard("ASUS ROG B650", "AM5", 4);
        PowerSupplyUnit psu = new PowerSupplyUnit("750W Gold", 750, 0.90);
        WorkstationPC station = new WorkstationPC("DeepLearning-Rig", motherboard, psu);
        station.installComponent(new ProcessorUnit("Intel Core i9", 22000.0, "LGA1700", 24, 5.8, 253));
        station.installComponent(new ProcessorUnit("AMD Ryzen 9 7950X", 24900.0, "AM5", 16, 5.7, 170));
        station.installComponent(new GraphicsAccelerator("NVIDIA RTX 4080 Super", 47000.0, 16, 512, 320));
        station.installComponent(new GraphicsAccelerator("Тестова відеокарта", 50000.0, 24, 600, 450));

        int[] speedSamples = {7450, 7300, 7410};
        NvmeSsdDrive drive = new NvmeSsdDrive("Samsung 990 Pro 2TB", 7000.0, 2000, 7450, speedSamples);
        speedSamples[0] = 0;
        int[] copy = drive.getSpeedSamples();
        copy[1] = 0;
        System.out.println("Збережені тести SSD: " + Arrays.toString(drive.getSpeedSamples()));
        station.installComponent(drive);
        System.out.println(station);
    }

    static class Motherboard {
        private final String model;
        private final String socketType;
        private final int maxExpansionSlots;

        public Motherboard(String model, String socketType, int maxExpansionSlots) {
            this.model = model;
            this.socketType = socketType;
            this.maxExpansionSlots = Math.max(1, Math.min(8, maxExpansionSlots));
        }

        public boolean isSocketCompatible(String cpuSocket) {
            return socketType.equalsIgnoreCase(cpuSocket);
        }

        public int getMaxExpansionSlots() {
            return maxExpansionSlots;
        }

        @Override
        public String toString() {
            return model + " (сокет: " + socketType + ")";
        }
    }

    static class PowerSupplyUnit {
        private final String model;
        private final int maxOutputWatts;
        private final double efficiencyCoefficient;

        public PowerSupplyUnit(String model, int maxOutputWatts, double efficiencyCoefficient) {
            if (maxOutputWatts <= 0 || !(efficiencyCoefficient >= 0.80 && efficiencyCoefficient <= 0.96)) {
                throw new IllegalArgumentException("Некоректні параметри блока живлення");
            }
            this.model = model;
            this.maxOutputWatts = maxOutputWatts;
            this.efficiencyCoefficient = efficiencyCoefficient;
        }

        public int getSafeContinuousWatts() {
            return (int) (maxOutputWatts * 0.85);
        }

        public double calculateWallPowerDraw(int internalLoadWatts) {
            return internalLoadWatts / efficiencyCoefficient;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "%s (безпечний ліміт: %d Вт, ККД: %.0f%%)",
                    model, getSafeContinuousWatts(), 100.0 * efficiencyCoefficient);
        }
    }

    static abstract class AbstractHardwareComponent {
        private final String modelName;
        private final double priceUah;

        public AbstractHardwareComponent(String modelName, double priceUah) {
            this.modelName = modelName;
            this.priceUah = priceUah >= 0.0 && Double.isFinite(priceUah) ? priceUah : 0.0;
        }

        public double getPriceUah() {
            return priceUah;
        }

        public abstract int getPowerWatts();

        public abstract double getBenchmarkScore();

        public abstract String getCategory();

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "[%s] %s (%d Вт | Score: %.2f)",
                    getCategory(), modelName, getPowerWatts(), getBenchmarkScore());
        }
    }

    static class ProcessorUnit extends AbstractHardwareComponent {
        private final String socket;
        private final int cores;
        private final double boostClockGhz;
        private final int tdpWatts;

        public ProcessorUnit(String modelName, double priceUah, String socket, int cores, double boostClockGhz, int tdpWatts) {
            super(modelName, priceUah);
            this.socket = socket;
            this.cores = cores;
            this.boostClockGhz = boostClockGhz;
            this.tdpWatts = tdpWatts;
        }

        public String getSocket() {
            return socket;
        }

        @Override
        public int getPowerWatts() {
            return tdpWatts;
        }

        @Override
        public double getBenchmarkScore() {
            return cores * boostClockGhz * 120.0;
        }

        @Override
        public String getCategory() {
            return "CPU";
        }
    }

    static class GraphicsAccelerator extends AbstractHardwareComponent {
        private final int vramGb;
        private final int tensorCores;
        private final int boardPowerWatts;

        public GraphicsAccelerator(String modelName, double priceUah, int vramGb, int tensorCores, int boardPowerWatts) {
            super(modelName, priceUah);
            this.vramGb = vramGb;
            this.tensorCores = tensorCores;
            this.boardPowerWatts = boardPowerWatts;
        }

        @Override
        public int getPowerWatts() {
            return boardPowerWatts;
        }

        @Override
        public double getBenchmarkScore() {
            return vramGb * 250.0 + tensorCores * 1.5;
        }

        @Override
        public String getCategory() {
            return "GPU";
        }
    }

    static class NvmeSsdDrive extends AbstractHardwareComponent {
        private final int capacityGb;
        private final int readSpeedMbSec;
        private final int[] speedSamples;

        public NvmeSsdDrive(String modelName, double priceUah, int capacityGb, int readSpeedMbSec, int[] speedSamples) {
            super(modelName, priceUah);
            this.capacityGb = capacityGb;
            this.readSpeedMbSec = readSpeedMbSec;
            this.speedSamples = speedSamples.clone();
        }

        public int[] getSpeedSamples() {
            return speedSamples.clone();
        }

        @Override
        public int getPowerWatts() {
            return 12;
        }

        @Override
        public double getBenchmarkScore() {
            return readSpeedMbSec * 0.25;
        }

        @Override
        public String getCategory() {
            return "NVMe SSD";
        }
    }

    static class WorkstationPC {
        private final String buildName;
        private final Motherboard motherboard;
        private final PowerSupplyUnit psu;
        private final AbstractHardwareComponent[] components;
        private int componentCount;

        public WorkstationPC(String buildName, Motherboard motherboard, PowerSupplyUnit psu) {
            this.buildName = buildName;
            this.motherboard = motherboard;
            this.psu = psu;
            this.components = new AbstractHardwareComponent[motherboard.getMaxExpansionSlots()];
        }

        public boolean installComponent(AbstractHardwareComponent comp) {
            if (comp == null || componentCount == components.length) {
                System.out.println("Відмова: відсутня деталь або вільний слот.");
                return false;
            }
            if (comp instanceof ProcessorUnit) {
                ProcessorUnit cpu = (ProcessorUnit) comp;
                if (!motherboard.isSocketCompatible(cpu.getSocket())) {
                    System.out.println("Відмова: сокет " + cpu.getSocket() + " несумісний з " + motherboard + ".");
                    return false;
                }
            }
            if (comp.getPowerWatts() < 0 || (long) getTotalPowerWatts() + comp.getPowerWatts() > psu.getSafeContinuousWatts()) {
                System.out.println("Відмова: некоректна потужність або перевищено безпечний ліміт БЖ.");
                return false;
            }
            components[componentCount++] = comp;
            System.out.println("Встановлено: " + comp);
            return true;
        }

        public int getTotalPowerWatts() {
            int power = 0;
            for (int i = 0; i < componentCount; i++) {
                power += components[i].getPowerWatts();
            }
            return power;
        }

        public double getTotalSystemScore() {
            double score = 0.0;
            for (int i = 0; i < componentCount; i++) {
                score += components[i].getBenchmarkScore();
            }
            return score;
        }

        public double getTotalBuildPrice() {
            double price = 0.0;
            for (int i = 0; i < componentCount; i++) {
                price += components[i].getPriceUah();
            }
            return price;
        }

        @Override
        public String toString() {
            int load = getTotalPowerWatts();
            return String.format(Locale.ROOT,
                    "Збірка '%s'%nПлата: %s, слотів: %d/%d%nБЖ: %s%nНавантаження: %d Вт, з розетки: %.2f Вт%n"
                            + "Продуктивність: %.2f бала%nВартість: %.2f грн",
                    buildName, motherboard, componentCount, components.length, psu, load,
                    psu.calculateWallPowerDraw(load), getTotalSystemScore(), getTotalBuildPrice());
        }
    }
}
