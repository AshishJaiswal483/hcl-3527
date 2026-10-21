class StudentInfo {
    String name;
    int age;

    StudentInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " " + age);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        StudentInfo s = new StudentInfo("Ashish", 24);
        s.display();
    }
}