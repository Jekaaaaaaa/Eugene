package semester1.practice06;

import java.util.Locale;

public class Practice06_14 {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        lamp.turnOn();
        lamp.status();
        lamp.toggle();
        lamp.status();
        lamp.toggle();
        lamp.status();
        lamp.turnOff();
        lamp.status();
    }

    static class Lamp {
        public boolean isOn;
    
        public void turnOn() {
            isOn = true;
        }
    
        public void turnOff() {
            isOn = false;
        }
    
        public void toggle() {
            isOn = !isOn;
        }
    
        public void status() {
            System.out.println(isOn ? "Лампа світить" : "Лампа вимкнена");
        }
    }
}
