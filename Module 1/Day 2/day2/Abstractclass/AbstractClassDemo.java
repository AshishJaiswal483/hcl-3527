package day2;

abstract class Animal {
    abstract void sound();

    void eat() {
        System.out.println("day2.Animal is eating");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("day2.Dog barks");
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Animal a = new Dog();

        a.sound();
        a.eat();
    }
}