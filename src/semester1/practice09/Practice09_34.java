package semester1.practice09;

public class Practice09_34 {
    public static void main(String[] args) {
        Spacecraft ship = new Spacecraft("Оріон", 20.0, 3);
        ship.addThruster(new ChemicalThruster("C-01", 120.0, 25.0));
        ship.addThruster(new IonThruster("I-01", 0.4, 0.01));
        System.out.println(ship);
        System.out.println("Сумарна тяга: " + ship.getTotalThrustKn() + " кН");
        System.out.println("Початкове прискорення: " + ship.getInitialAcceleration() + " м/с²");
    }

    static abstract class AbstractThruster {
        private final String thrusterId;

        public AbstractThruster(String thrusterId) {
            this.thrusterId = thrusterId;
        }

        public abstract double getThrustKn();

        public abstract double getFuelBurnRate();

        @Override
        public String toString() {
            return thrusterId + ": " + getThrustKn() + " кН, витрата: " + getFuelBurnRate() + " кг/с";
        }
    }

    static class ChemicalThruster extends AbstractThruster {
        private double thrustKn;
        private double fuelBurnRate;

        public ChemicalThruster(String thrusterId, double thrustKn, double fuelBurnRate) {
            super(thrusterId);
            this.thrustKn = thrustKn;
            this.fuelBurnRate = fuelBurnRate;
        }

        @Override
        public double getThrustKn() {
            return thrustKn;
        }

        @Override
        public double getFuelBurnRate() {
            return fuelBurnRate;
        }
    }

    static class IonThruster extends AbstractThruster {
        private double thrustKn;
        private double fuelBurnRate;

        public IonThruster(String thrusterId, double thrustKn, double fuelBurnRate) {
            super(thrusterId);
            this.thrustKn = thrustKn;
            this.fuelBurnRate = fuelBurnRate;
        }

        @Override
        public double getThrustKn() {
            return thrustKn;
        }

        @Override
        public double getFuelBurnRate() {
            return fuelBurnRate;
        }
    }

    static class Spacecraft {
        private final String shipName;
        private final double dryMassTons;
        private final AbstractThruster[] thrusters;
        private int count;

        public Spacecraft(String shipName, double dryMassTons, int capacity) {
            if (!(dryMassTons > 0.0) || !Double.isFinite(dryMassTons)) {
                throw new IllegalArgumentException("Маса корабля має бути додатною");
            }
            this.shipName = shipName;
            this.dryMassTons = dryMassTons;
            this.thrusters = new AbstractThruster[capacity];
        }

        public void addThruster(AbstractThruster thruster) {
            if (thruster != null && count < thrusters.length) {
                thrusters[count++] = thruster;
            }
        }

        public double getTotalThrustKn() {
            double thrust = 0.0;
            for (int i = 0; i < count; i++) {
                thrust += thrusters[i].getThrustKn();
            }
            return thrust;
        }

        public double getInitialAcceleration() {
            return getTotalThrustKn() / dryMassTons;
        }

        @Override
        public String toString() {
            return shipName + ", суха маса: " + dryMassTons + " т, двигунів: " + count;
        }
    }
}
