class Student {
    String name;
    int age;

    void display() {
        System.out.println(name);
        System.out.println(age);
    }
}

public class ClassObject {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.name = "Ashish";
        s1.age = 24;

        s1.display();
    }
}