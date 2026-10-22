package day6.StreamCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectors {

    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ashish", "IT", 30000),
                new Employee(2, "Aman", "HR", 25000),
                new Employee(3, "Sushil", "IT", 40000),
                new Employee(4, "Rahul", "HR", 20000)
        );

        // Group employees by department
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));

        System.out.println("Departments: " + grouped.keySet());
        System.out.println("IT employees: "
                + grouped.get("IT").stream()
                         .map(e -> e.name)
                         .collect(Collectors.toList()));

        // Partition by salary
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary >= 30000));

        System.out.println("Salary >= 30000: "
                + partitioned.get(true).size());

        // Join employee names
        String names = employees.stream()
                .map(e -> e.name)
                .collect(Collectors.joining(", "));

        System.out.println("Names: " + names);

        // Convert IDs to names
        Map<Integer, String> employeeMap = employees.stream()
                .collect(Collectors.toMap(e -> e.id, e -> e.name));

        System.out.println("Employee map: " + employeeMap);
    }
}