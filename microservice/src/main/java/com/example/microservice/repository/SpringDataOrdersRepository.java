package com.example.microservice.repository;

import com.example.microservice.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpringDataOrdersRepository extends CrudRepository<Order, Long> {

    Optional<Order> findOrderByUserId(Integer userId);

}
