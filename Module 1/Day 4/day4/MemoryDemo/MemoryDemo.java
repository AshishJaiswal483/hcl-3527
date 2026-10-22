package day4.MemoryDemo;

// Concept: Objects are created on the heap, while local variables and references are used within method stack frames.
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class MemoryDemo {

    public static void main(String[] args) {
        int age = 22;

        Student s1 = new Student("Ashish");

        System.out.println("Age: " + age);
        System.out.println("MemoryDemo.Student: " + s1.name);
    }
}
