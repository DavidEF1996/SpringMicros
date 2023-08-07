package com.mongo.service.mongoMicro.controller;

import com.mongo.service.mongoMicro.entity.Calificacion;
import com.mongo.service.mongoMicro.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;


    @PostMapping
    public ResponseEntity<Calificacion> createCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.create(calificacion));
    }

    @GetMapping
    public ResponseEntity<List<Calificacion>> getCalificaciones(){
        return ResponseEntity.ok(calificacionService.getCalificaciones());
    }

    @GetMapping("/usuarios/{idUsuario}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorUsuario(@PathVariable String idUsuario){
        return ResponseEntity.ok(calificacionService.getCalificacionesByUsuarioId(idUsuario));
    }

    @GetMapping("/hoteles/{idHotel}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorHotel(@PathVariable String idHotel){
        return ResponseEntity.ok(calificacionService.getCalificacionesByHotel(idHotel));
    }
}
