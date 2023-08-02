package com.micro.usuario.usuarioservice.exceptions;

import com.micro.usuario.usuarioservice.exceptions.ResourceNotFoundException;
import com.micro.usuario.usuarioservice.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        String mensaje = resourceNotFoundException.getMessage();
ApiResponse resonse = new ApiResponse().builder()
        .mensaje(mensaje)
        .success(true)
        .status(HttpStatus.NOT_FOUND)
        .build();
return new ResponseEntity<>(resonse,HttpStatus.NOT_FOUND);
    }
}
