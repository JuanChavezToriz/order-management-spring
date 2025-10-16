package com.example.microservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PENDIENTE("P-204", "ORDEN PENDIENTE"),
    APROBADO("A-200", "APROBADO"),
    CANCELADA("C-400", "CANCELADA");

    private final String code;
    private final String message;
}
