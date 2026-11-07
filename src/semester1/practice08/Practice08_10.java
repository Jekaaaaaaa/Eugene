package semester1.practice08;

public class Practice08_10 {
    public static void main(String[] args) {
        Dog dog = new Dog("Рекс", 4, 24.0, "Лабрадор");
        Cat cat = new Cat("Мурка", 3, 4.0, true);
        System.out.println(dog + ". " + dog.fetchStick());
        System.out.println(cat + ". " + cat.purr());
    }

    static class Animal {
        private String name;
        private int age;
        private double weight;

        public Animal(String name, int age, double weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return name + ", вік: " + age + ", вага: " + weight + " кг";
        }
    }

    static class Dog extends Animal {
        private String breed;

        public Dog(String name, int age, double weight, String breed) {
            super(name, age, weight);
            this.breed = breed;
        }

        public String fetchStick() {
            return "Пес приніс палицю";
        }

        @Override
        public String toString() {
            return super.toString() + ", порода: " + breed;
        }
    }

    static class Cat extends Animal {
        private boolean isIndoor;

        public Cat(String name, int age, double weight, boolean isIndoor) {
            super(name, age, weight);
            this.isIndoor = isIndoor;
        }

        public String purr() {
            return "Кішка муркоче";
        }

        @Override
        public String toString() {
            return super.toString() + (isIndoor ? ", хатня" : ", вулична");
        }
    }
}
