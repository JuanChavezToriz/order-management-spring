package com.example.microservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO for {@link com.example.microservice.entity.User}
 */
@Data
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
}