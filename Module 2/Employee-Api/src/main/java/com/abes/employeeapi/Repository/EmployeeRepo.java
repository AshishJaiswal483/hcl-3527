package com.abes.employeeapi.Repository;

import com.abes.employeeapi.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    List<Employee> findByDepartment_DeptName(String name);
}
