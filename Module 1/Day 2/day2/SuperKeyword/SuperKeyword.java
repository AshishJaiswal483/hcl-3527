package day2.SuperKeyword;

class Parent {
    Parent() {
        System.out.println("day2.SuperKeyword.Parent constructor");
    }

    void display() {
        System.out.println("day2.SuperKeyword.Parent method");
    }
}

class Child extends Parent {
    Child() {
        super();
        System.out.println("day2.SuperKeyword.Child constructor");
    }

    @Override
    void display() {
        super.display();
        System.out.println("day2.SuperKeyword.Child method");
    }
}

public class SuperKeyword {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}