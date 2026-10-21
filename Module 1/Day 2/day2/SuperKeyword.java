class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }

    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    Child() {
        super();
        System.out.println("Child constructor");
    }

    @Override
    void display() {
        super.display();
        System.out.println("Child method");
    }
}

public class SuperKeyword {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}