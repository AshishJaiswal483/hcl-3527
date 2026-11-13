package com.abes.employeeapi.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="departmentTable")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(nullable = false)
    private String deptName;

   public Department(){

   }

    @OneToMany(mappedBy = "department")
    private List<Employee>employees=new ArrayList<>();

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(Employee e) {
        employees.add(e);
    }
}
