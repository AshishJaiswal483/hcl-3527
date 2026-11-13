package com.abes.employeeapi.Service;

import com.abes.employeeapi.DTO.UsersRequestDto;
import com.abes.employeeapi.Entity.Users;
import com.abes.employeeapi.Repository.UsersRepo;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsersService{
    private final UsersRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UsersService(UsersRepo userRepo,PasswordEncoder passwordEncoder,AuthenticationManager authenticationManager,JwtService jwtService) {
        this.userRepo = userRepo;
        this.passwordEncoder=passwordEncoder;
        this.authenticationManager=authenticationManager;
        this.jwtService=jwtService;
    }

 public String regesterUsers(UsersRequestDto u){

     if (userRepo.existsByUserName(u.getUserName())) {
         throw new ResponseStatusException(
                 HttpStatus.CONFLICT,
                 "Username already exists"
         );
     }

     Users user = new Users();
     user.setUserName(u.getUserName());
     user.setRole("USER");
     user.setPassword(passwordEncoder.encode(u.getPassword()));

     userRepo.save(user);

     return "USER REGISTERED SUCCESSFULLY";
 }

 public String Login(String userName,String password){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName,password)
        );
     String token=jwtService.generateToken(userName);
     return token;
 }

}
