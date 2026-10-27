package org.abes;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private int emp_id;

    private String Emp_name;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return Emp_name;
    }

    public void setEmp_name(String emp_name) {
        Emp_name = emp_name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
