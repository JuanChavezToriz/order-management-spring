package com.example.microservice.service;

import com.example.microservice.constant.AppError;
import com.example.microservice.dto.OrderDto;
import com.example.microservice.entity.Order;
import com.example.microservice.exception.OrdersException;
import com.example.microservice.mapper.OrderMapper;
import com.example.microservice.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrderMapper orderMapper;

    private static final Set<String> ALLOWED_STATUSES = Set.of("PENDIENTE", "APROBADO", "CANCELADA");

    public OrderDto findByUserId(Integer userId) {
        return ordersRepository.findByUserId(userId)
                .map(orderMapper::toDto)
                .orElseThrow(() -> new OrdersException("E-101", "ORDER NOT FOUND BY USER_ID: " + userId));
    }

    public OrderDto updateOrder(Integer userId, OrderDto dto) {
        Order order = ordersRepository.findByUserId(userId).orElseThrow(() -> new OrdersException("E-101",
                        "ORDER NOT FOUND BY USER_ID: " + userId));

        if (dto.getOrderNumber() != null && !dto.getOrderNumber().isBlank())
            order.setOrderNumber(dto.getOrderNumber().trim());

        if (dto.getStatusOrder() != null && !dto.getStatusOrder().isBlank()) {
            String status = dto.getStatusOrder().trim().toUpperCase();
            if (!ALLOWED_STATUSES.contains(status)) {
                throw new OrdersException("E-102",
                        "INVALID STATUS: " + dto.getStatusOrder());
            }
            order.setStatusOrder(status);
        }

        return orderMapper.toDto(ordersRepository.save(order));
    }



}
