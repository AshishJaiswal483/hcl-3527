package day2;
class Animal {
    void sound() {
        System.out.println("day2.Abstractclass.Animal makes a sound");
    }
}

class Dog extends day2.Abstractclass.Animal {
    @Override
    void sound() {
        System.out.println("day2.Abstractclass.Dog barks");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        day2.Abstractclass.Dog d = new day2.Abstractclass.Dog();
        d.sound();
    }
}