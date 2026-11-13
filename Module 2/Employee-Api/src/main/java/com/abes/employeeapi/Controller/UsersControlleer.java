package com.abes.employeeapi.Controller;

import com.abes.employeeapi.DTO.LoginRequestDto;
import com.abes.employeeapi.DTO.UsersRequestDto;
import com.abes.employeeapi.Entity.Users;
import com.abes.employeeapi.Service.UsersService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/users/api")
public class UsersControlleer {

    private final UsersService userService;

   public UsersControlleer(UsersService userService){
       this.userService=userService;
   }

   @PostMapping("/registerUsers")
    public String registerUsers(@Valid @RequestBody UsersRequestDto u){
       String message=userService.regesterUsers(u);
       return message;
   }

   @PostMapping("/login")
    public String Login(@RequestBody LoginRequestDto request){
      String message= userService.Login(request.getUsername(),request.getPassword());
      return message;
   }
}
