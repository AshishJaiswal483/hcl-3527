package com.abes.employeeapi.DTO;

public class EmployeeResponseDto {

    private int employeeId;
    private String employeeName;
    private String deptName;

    public EmployeeResponseDto(int employeeId, String employeeName, String deptName){
        this.employeeId=employeeId;
        this.deptName=deptName;
        this.employeeName=employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDeptName() {
        return deptName;
    }
}
