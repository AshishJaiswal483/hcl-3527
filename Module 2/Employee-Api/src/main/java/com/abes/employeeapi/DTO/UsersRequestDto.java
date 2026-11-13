package com.abes.employeeapi.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UsersRequestDto {

    @NotBlank(message = "username name cannot be blank")
    @Size(min=2)
    private String userName;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 6, message = "Password must contain at least 6 characters")
    private String password;

    @NotBlank(message = "role cannot be blank")
    @Size(min=2)
    private String role;

    public UsersRequestDto(String userName,String password,String role){
        this.userName=userName;
        this.password=password;
        this.role=role;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
