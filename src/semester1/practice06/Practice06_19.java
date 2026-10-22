package semester1.practice06;

import java.util.Locale;

public class Practice06_19 {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        double fahrenheit = converter.celsiusToFahrenheit(25);
        double celsius = converter.fahrenheitToCelsius(fahrenheit);
        System.out.println("25 °C = " + fahrenheit + " °F; назад: " + celsius + " °C");
    }

    static class TemperatureConverter {
        public double celsiusToFahrenheit(double c) {
            return c * 1.8 + 32;
        }
    
        public double fahrenheitToCelsius(double f) {
            return (f - 32) / 1.8;
        }
    }
}
