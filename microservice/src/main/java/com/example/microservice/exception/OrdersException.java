package com.example.microservice.exception;


import com.example.microservice.constant.AppError;
import lombok.Getter;

@Getter
public class OrdersException extends RuntimeException {

    private final String code;

    public OrdersException(AppError error) {
        super(error.getMessage());
        this.code = error.getCode();
    }

    public OrdersException(String code, String message) {
        super(message);
        this.code = code;
    }

    public OrdersException(AppError error, Throwable cause) {
        super(error.getMessage(), cause);
        this.code = error.getCode();
    }

}
