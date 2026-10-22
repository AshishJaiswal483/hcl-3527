package day4.ReferenceDemo;// variable and reference store in stack and object stored in heap. when no refrence varibale pomtimg to object, object becomes eligible for garbage collector.

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class ReferenceDemo {
    public static void main(String[] args) {

        Student s1 = new Student("Ashish");

        Student s2 = s1;

        System.out.println("Before change:");
        System.out.println(s1.name);
        System.out.println(s2.name);

        s2.name = "Rahul";

        System.out.println("After change:");
        System.out.println(s1.name);
        System.out.println(s2.name);
    }
}
