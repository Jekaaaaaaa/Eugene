package semester1.practice06;

import java.util.Locale;

public class Practice06_6 {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone();
        phone.model = "Samsung";
        phone.batteryLevel = 100;
        phone.isTurnedOn = true;
        phone.batteryLevel -= 35;
        if (phone.batteryLevel <= 0) {
            phone.batteryLevel = 0;
            phone.isTurnedOn = false;
        }
        System.out.println(phone.model + ": заряд " + phone.batteryLevel + "%, увімкнено: " + phone.isTurnedOn);
    }

    static class Smartphone {
        public String model;
        public int batteryLevel;
        public boolean isTurnedOn;
    }
}
