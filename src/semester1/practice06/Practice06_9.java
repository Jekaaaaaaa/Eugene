package semester1.practice06;

import java.util.Locale;

public class Practice06_9 {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.sayHello();
        greeter.sayHelloTo("Денис");
    }

    static class Greeter {
        public void sayHello() {
            System.out.println("Привіт усім!");
        }
    
        public void sayHelloTo(String name) {
            System.out.println("Привіт, " + name + "! Раді тебе бачити.");
        }
    }
}
