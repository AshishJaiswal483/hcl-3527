package day3.ComparableComparatorDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    int salary;

    Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + salary;
    }
}

public class ComparableComparatorDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(3, "Aman", 30000));
        employees.add(new Employee(1, "Ashish", 50000));
        employees.add(new Employee(2, "Rahul", 40000));

        // Natural order: sort by ID
        Collections.sort(employees);
        System.out.println("Sorted by ID: " + employees);

        // Custom order: sort by salary
        employees.sort(
            Comparator.comparingInt(e -> e.salary)
        );
        System.out.println("Sorted by salary: " + employees);
    }
}
