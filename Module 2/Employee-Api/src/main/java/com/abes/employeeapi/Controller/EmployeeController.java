package com.abes.employeeapi.Controller;

import com.abes.employeeapi.DTO.DepartmentRequestDto;
import com.abes.employeeapi.DTO.EmployeeResponseDto;
import com.abes.employeeapi.Entity.Department;
import com.abes.employeeapi.Entity.Employee;
import com.abes.employeeapi.Service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/Employee/api")
public class EmployeeController {

    private final EmployeeService employeeservice;

    public EmployeeController(EmployeeService s){
        this.employeeservice=s;
    }

    @PostMapping("/add")
    public ResponseEntity<String> Add(@Valid @RequestBody DepartmentRequestDto d){
        employeeservice.add(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Department and employees added successfully");
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<EmployeeResponseDto>>GetAll(){
        List<EmployeeResponseDto>allEmployee=employeeservice.GetAll();
        return ResponseEntity.status(HttpStatus.OK).body(allEmployee);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeResponseDto>getById(@PathVariable @Positive(message = "Employee id much be greater than zero") int id){
        EmployeeResponseDto emp=employeeservice.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @GetMapping("/getByDeptName")
    public ResponseEntity<List<EmployeeResponseDto>>getAllEmpByDeptname(@RequestParam @NotBlank(message = "name cannot be empty") @Size(min = 2,message = "min size should be greater than 2") String name){
        List<EmployeeResponseDto>empList=employeeservice.getAllEmployee(name);
        return  ResponseEntity.status(HttpStatus.OK).body(empList);    }

    @DeleteMapping("/deleteByEmpId/{Id}")
    public String deleteByEmpId(@PathVariable @Positive(message = "Employee id much be greater than zero") int Id){
        employeeservice.deleteByEmpId(Id);
        return "Deleted";
    }

    @GetMapping("/totalCountEmp")
    public long totalCountEmp(){
        return employeeservice.totalCountEmp();
    }

    @GetMapping("/totalCountDept")
    public long totalCountDept(){
        return employeeservice.totalCountDept();
    }
}
