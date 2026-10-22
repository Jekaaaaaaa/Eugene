package semester1.practice06;

import java.util.Locale;

public class Practice06_29 {
    public static void main(String[] args) {
        CarSpeedometer speedometer = new CarSpeedometer();
        speedometer.accelerate(100);
        System.out.println("Швидкість: " + speedometer.getSpeed());
        speedometer.accelerate(200);
        System.out.println("Верхня межа: " + speedometer.getSpeed());
        speedometer.brake(300);
        System.out.println("Нижня межа: " + speedometer.getSpeed());
    }

    static class CarSpeedometer {
        private int speed = 0;
    
        public void accelerate(int delta) {
            if (delta < 0) {
                System.out.println("Приріст швидкості не може бути від'ємним.");
                return;
            }
            speed = (int) Math.min(240L, (long) speed + delta);
        }
    
        public void brake(int delta) {
            if (delta < 0) {
                System.out.println("Зменшення швидкості не може бути від'ємним.");
                return;
            }
            speed = Math.max(0, speed - delta);
        }
    
        public int getSpeed() {
            return speed;
        }
    }
}
