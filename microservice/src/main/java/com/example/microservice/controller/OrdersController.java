package com.example.microservice.controller;

import com.example.microservice.dto.OrderDto;
import com.example.microservice.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping(path = "/{userId}")
    public ResponseEntity<OrderDto> findByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(ordersService.findByUserId(userId));
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<OrderDto> updateByUserId(@PathVariable Integer userId, @RequestBody OrderDto order) {
       OrderDto orderDto = ordersService.updateOrder(userId, order);
        return ResponseEntity.ok(orderDto);
    }
}
