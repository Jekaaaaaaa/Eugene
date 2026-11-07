package semester1.practice07;

public class Practice07_36 {
    public static void main(String[] args) {
        Processor cpu = new Processor("Ryzen 5", 3.6, 6000.0);
        Memory ram = new Memory(16, 3200, 1800.0);
        Computer computer = new Computer("Робочий ПК", cpu, ram, 2000.0);
        computer.printSpecs();
        computer.upgradeMemory(new Memory(32, 3200, 3300.0));
        computer.printSpecs();
    }

    static class Processor {
        private String model;
        private double frequencyGHz;
        private double price;

        public Processor(String model, double frequencyGHz, double price) {
            this.model = model;
            this.frequencyGHz = frequencyGHz;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getSpecs() {
            return model + ", " + frequencyGHz + " ГГц";
        }
    }

    static class Memory {
        private int sizeGB;
        private int frequencyMHz;
        private double price;

        public Memory(int sizeGB, int frequencyMHz, double price) {
            this.sizeGB = sizeGB;
            this.frequencyMHz = frequencyMHz;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getSpecs() {
            return sizeGB + " ГБ, " + frequencyMHz + " МГц";
        }
    }

    static class Computer {
        private String title;
        private Processor cpu;
        private Memory ram;
        private double casePrice;

        public Computer(String title, Processor cpu, Memory ram, double casePrice) {
            this.title = title;
            this.cpu = cpu;
            this.ram = ram;
            this.casePrice = casePrice;
        }

        public double calculateTotalPrice() {
            return cpu.getPrice() + ram.getPrice() + casePrice;
        }

        public void upgradeMemory(Memory newRam) {
            this.ram = newRam;
            System.out.println("Встановлено нову пам'ять: " + ram.getSpecs());
        }

        public void printSpecs() {
            System.out.println(title + ", процесор: " + cpu.getSpecs() + ", пам'ять: " + ram.getSpecs()
                    + ", загальна ціна: " + calculateTotalPrice() + " грн");
        }
    }
}
