package semester1.practice06;

import java.util.Locale;

public class Practice06_28 {
    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();
        thermometer.setTemperature(22.5);
        thermometer.setTemperature(-300);
        System.out.println("Температура після некоректного введення: " + thermometer.getTemperature());
    }

    static class Thermometer {
        private double temperature;
    
        public void setTemperature(double t) {
            if (!Double.isFinite(t) || t < -273.15) {
                System.out.println("Помилка: температура не може бути нижчою за абсолютний нуль або нескінченною.");
                return;
            }
            this.temperature = t;
        }
    
        public double getTemperature() {
            return temperature;
        }
    }
}
