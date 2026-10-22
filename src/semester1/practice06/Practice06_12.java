package semester1.practice06;

import java.util.Locale;

public class Practice06_12 {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.changeColor("Червоний");
        light.showSignal();
        light.changeColor("Жовтий");
        light.showSignal();
        light.changeColor("Зелений");
        light.showSignal();
    }

    static class TrafficLight {
        public String currentColor;
    
        public void changeColor(String newColor) {
            this.currentColor = newColor;
        }
    
        public void showSignal() {
            if ("Червоний".equalsIgnoreCase(currentColor)) {
                System.out.println("Стій!");
            } else if ("Жовтий".equalsIgnoreCase(currentColor)) {
                System.out.println("Увага!");
            } else if ("Зелений".equalsIgnoreCase(currentColor)) {
                System.out.println("Їдь!");
            } else {
                System.out.println("Невідомий сигнал.");
            }
        }
    }
}
