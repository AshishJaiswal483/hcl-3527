package com.abes.employeemanagementapi.Repository;

import com.abes.employeemanagementapi.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepo extends JpaRepository<Card,Integer> {



    Optional<Card>findByEmployee_Id(int id);
}
