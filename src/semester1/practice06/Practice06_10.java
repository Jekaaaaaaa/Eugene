package semester1.practice06;

import java.util.Locale;

public class Practice06_10 {
    public static void main(String[] args) {
        Animal cat = new Animal();
        cat.species = "Кіт";
        cat.name = "Мурчик";
        Animal dog = new Animal();
        dog.species = "Собака";
        dog.name = "Рекс";
        cat.printInfo();
        cat.makeSound();
        dog.printInfo();
        dog.makeSound();
    }

    static class Animal {
        public String species;
        public String name;
    
        public void makeSound() {
            System.out.println(name + " видає звук!");
        }
    
        public void printInfo() {
            System.out.println("Вид: " + species + "; кличка: " + name);
        }
    }
}
