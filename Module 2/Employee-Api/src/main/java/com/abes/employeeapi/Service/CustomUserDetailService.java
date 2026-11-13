package com.abes.employeeapi.Service;


import com.abes.employeeapi.Entity.Users;
import com.abes.employeeapi.Repository.UsersRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UsersRepo userRepo;

    public CustomUserDetailService(UsersRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<Users>user=userRepo.findByUserName(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No user with this name");
        }
        Users u=user.get();

        UserDetails userDatail=User.withUsername(u.getUserName()).password(u.getPassword()).roles(u.getRole()).build();

        return userDatail;

    }
}
