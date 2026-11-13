package com.abes.employeeapi.Repository;

import com.abes.employeeapi.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users>findByUserName(String name);
    boolean existsByUserName(String name);
}
