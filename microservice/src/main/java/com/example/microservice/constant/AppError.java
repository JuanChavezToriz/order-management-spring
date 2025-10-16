package com.example.microservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppError {

    ERROR_GENERAL("E-102", "ERROR GENERAL"),
    JPA_EXCEPTION("JPA_EXCEPTION", "JPA_EXCEPTION");

    private final String code;
    private final String message;
}
