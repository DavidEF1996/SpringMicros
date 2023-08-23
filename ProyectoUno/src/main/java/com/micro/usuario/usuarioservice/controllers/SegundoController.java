package com.micro.usuario.usuarioservice.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/segundoControlador")
public class SegundoController {


    @GetMapping
    public ResponseEntity<List<String>> listaPrueba(){
        List<String> lista =  Arrays.asList("David", "Fernando");
        return  new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
