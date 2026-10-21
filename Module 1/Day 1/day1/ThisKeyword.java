class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + this.name);
    }
}

public class ThisKeyword {
    public static void main(String[] args) {
        Employee e = new Employee("Ashish");
        e.display();
    }
}