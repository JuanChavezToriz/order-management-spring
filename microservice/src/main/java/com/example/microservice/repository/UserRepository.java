package com.example.microservice.repository;

import com.example.microservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    public List<User> findAll() {
        return springDataUserRepository.findAll();
    }

    public Optional<User> findById(long id) {
        return springDataUserRepository.findById(id);
    }

    public User save(User user) {
        return springDataUserRepository.save(user);
    }


}
