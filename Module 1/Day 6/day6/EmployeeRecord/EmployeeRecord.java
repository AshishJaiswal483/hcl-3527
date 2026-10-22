package day6.EmployeeRecord;

public record EmployeeRecord(int id, String name, double salary) {

    public EmployeeRecord {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }

    public static void main(String[] args) {
        EmployeeRecord employee =
                new EmployeeRecord(101, "Ashish", 30000);

        System.out.println(employee.id());
        System.out.println(employee.name());
        System.out.println(employee.salary());
        System.out.println(employee);
    }
}