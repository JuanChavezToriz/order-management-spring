package com.example.microservice.repository;

import com.example.microservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {

}
