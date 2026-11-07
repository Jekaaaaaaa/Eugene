package semester1.practice09;

import semester1.practice09.Practice09_31.AbstractSensor;
import semester1.practice09.Practice09_31.PressureSensor;
import semester1.practice09.Practice09_31.RadiationSensor;

public class Practice09_38 {
    public static void main(String[] args) {
        AbstractSensor[] sensors = {
                new PressureSensor("Резервуар", 1.0, 5.0, 3.0, 1.1),
                new RadiationSensor("Лабораторія", 0.0, 0.3, 0.7)
        };
        new SmartLab(new EmergencySiren(), sensors).runDiagnostics();
    }

    static class EmergencySiren {
        private boolean sounding;

        public void activate() {
            sounding = true;
        }

        public boolean isSounding() {
            return sounding;
        }
    }

    static class SmartLab {
        private final EmergencySiren siren;
        private final AbstractSensor[] sensors;

        public SmartLab(EmergencySiren siren, AbstractSensor[] sensors) {
            this.siren = siren;
            this.sensors = sensors.clone();
        }

        public void runDiagnostics() {
            boolean alarm = false;
            for (AbstractSensor sensor : sensors) {
                boolean triggered = sensor.isAlarmTriggered();
                alarm |= triggered;
                System.out.println(sensor + (triggered ? " — тривога" : " — норма"));
            }
            if (alarm) {
                siren.activate();
            }
            System.out.println("Сирена: " + (siren.isSounding() ? "увімкнена" : "вимкнена"));
        }
    }
}
