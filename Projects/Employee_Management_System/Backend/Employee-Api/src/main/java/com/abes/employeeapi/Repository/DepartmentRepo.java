package com.abes.employeeapi.Repository;

import com.abes.employeeapi.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository< Department,Integer> {

    Optional<Department>findByDeptName(String name);
}