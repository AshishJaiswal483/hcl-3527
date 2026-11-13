package com.abes.employeemanagementapi.Repository;

import com.abes.employeemanagementapi.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

    public List<Employee> findByName(String name);

    public List<Employee> findByDepartment(String department);

   public List<Employee> findByNameAndDepartment(
            String name, String department);

   public List<Employee> findByNameContaining(String keyword);

    public List<Employee> findByDepartmentOrderByNameAsc(String department);





    Optional<Employee> findByCard_cardId(int cardCardId);
}

