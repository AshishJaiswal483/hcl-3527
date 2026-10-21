package inheritancetypes;

class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

// Single inheritance
class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}

// Multilevel inheritance
class Puppy extends Dog {
    void weep() {
        System.out.println("Weeping");
    }
}

// Hierarchical inheritance
class Cat extends Animal {
    void meow() {
        System.out.println("Meowing");
    }
}

public class InheritanceTypes {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();
        p.bark();
        p.weep();

        Cat c = new Cat();
        c.eat();
        c.meow();
    }
}