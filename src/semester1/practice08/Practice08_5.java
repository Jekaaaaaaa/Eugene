package semester1.practice08;

public class Practice08_5 {
    public static void main(String[] args) {
        SensorNode sensor = new SensorNode("T-01", 0.7, 21.5);
        System.out.println(sensor);
    }

    static class SensorNode {
        private String sensorId;
        protected double calibrationOffset;
        private double rawValue;

        public SensorNode(String sensorId, double calibrationOffset, double rawValue) {
            this.sensorId = sensorId;
            this.calibrationOffset = calibrationOffset;
            this.rawValue = rawValue;
        }

        public String getSensorId() {
            return sensorId;
        }

        public double getCalibratedValue() {
            return rawValue + calibrationOffset;
        }

        @Override
        public String toString() {
            return getSensorId() + ", сирий показник: " + rawValue + ", відкалібрований: " + getCalibratedValue();
        }
    }
}
