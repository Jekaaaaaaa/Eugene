package semester1.practice06;

import java.util.Locale;

public class Practice06_2 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.model = "Camry";
        car1.year = 2021;
        car1.speed = 180;
        Car car2 = new Car();
        car2.brand = "BMW";
        car2.model = "M5";
        car2.year = 2023;
        car2.speed = 250;
        System.out.println(car1.brand + " " + car1.model + ", " + car1.year + ", " + car1.speed + " км/год");
        System.out.println(car2.brand + " " + car2.model + ", " + car2.year + ", " + car2.speed + " км/год");
        if (car1.year > car2.year) {
            System.out.println(car1.brand + " новіший.");
        } else if (car2.year > car1.year) {
            System.out.println(car2.brand + " новіший.");
        } else {
            System.out.println("Рік випуску однаковий.");
        }
    }

    static class Car {
        public String brand;
        public String model;
        public int year;
        public int speed;
    }
}
