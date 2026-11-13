package com.abes.employeeapi.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class EmployeeRequestDto {

    @Pattern(regexp = "^[a-zA-Z ]+$",
            message = "Employee name must contain only letters and spaces")
    @Size(min = 3,max = 30,message = "Employee name much be between 3 and 30 character")
    @NotBlank(message = "Employee name cannot be empty")
    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
