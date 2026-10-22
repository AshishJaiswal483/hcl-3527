package day2.Abstractclass1;

 abstract  class Animal {
    abstract void sound();

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Animal a = new Dog();

        a.sound();
        a.eat();
    }
}