package com.msvc.order.orderservice.exceptions;

public class OrderServiceException extends  RuntimeException{

    public OrderServiceException(String message) {
        super(message);
    }

    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorMessage() {
        return getMessage();
    }
}
