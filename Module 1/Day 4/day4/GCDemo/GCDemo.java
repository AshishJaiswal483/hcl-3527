package day4.GCDemo;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class GCDemo {
    public static void main(String[] args) {

        Student s1 = new Student("Ashish");

        System.out.println("day4.GCDemo.Student: " + s1.name);

        s1 = null;

        System.out.println("Reference removed.");

        System.gc();

        System.out.println("Program finished.");
    }
}
