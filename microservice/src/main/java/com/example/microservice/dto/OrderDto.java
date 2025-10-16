package com.example.microservice.dto;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO for {@link com.example.microservice.entity.Order}
 */
@Data
public class OrderDto implements Serializable {
    private Integer id;
    private Integer userId;
    private String orderNumber;
    private String statusOrder;
    private LocalDateTime createdAt;

}