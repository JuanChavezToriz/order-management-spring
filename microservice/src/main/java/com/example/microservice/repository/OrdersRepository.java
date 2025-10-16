package com.example.microservice.repository;

import com.example.microservice.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrdersRepository {

    private final SpringDataOrdersRepository ordersRepository;

    public Optional<Order> findByUserId(Integer userId) {
        return ordersRepository.findOrderByUserId(userId);
    }

    public Order save(Order order) {
        return ordersRepository.save(order);
    }
}
