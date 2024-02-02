package com.msvc.order.orderservice.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

    @ControllerAdvice
    public class OrderGlobalException {

        private static final Logger log = LoggerFactory.getLogger(OrderGlobalException.class);

        @ExceptionHandler(OrderServiceException.class)
        public ResponseEntity<Object> handleOrderServiceException(OrderServiceException ex, WebRequest request) {
            log.error("OrderServiceException occurred", ex);
            BodyException bodyException = new BodyException(HttpStatus.BAD_REQUEST.value(), ex.getErrorMessage());
            return new ResponseEntity<>(bodyException, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
            BodyException bodyException = new BodyException(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
            return new ResponseEntity<>(bodyException, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }