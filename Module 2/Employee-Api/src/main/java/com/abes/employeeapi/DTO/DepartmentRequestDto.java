package com.abes.employeeapi.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public class DepartmentRequestDto {

    @Size(min = 2)
    @Pattern(regexp ="^[a-zA-Z]+(?:[ ]+[a-zA-Z]+)*(?:[ ]*\\([a-zA-Z ]+\\))?$",message = "depatment name much contain letters only")
    @NotBlank(message = "Department name cannot be empty")
    private String departmentName;

//    @NotNull(message = "Employee list cannot be null")
    @NotEmpty(message = "At least one employee is required")
    @Valid
    private List<EmployeeRequestDto> empList;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<EmployeeRequestDto> getEmpList() {
        return empList;
    }

    public void setEmpList(List<EmployeeRequestDto> empList) {
        this.empList = empList;
    }

}
