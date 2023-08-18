package com.micro.usuario.usuarioservice.controllers;

import com.micro.usuario.usuarioservice.entity.CalificacionTrama;
import com.micro.usuario.usuarioservice.entity.Usuario;
import com.micro.usuario.usuarioservice.external.services.CalificacionServiceFeigth;
import com.micro.usuario.usuarioservice.service.CalificacionService;
import com.micro.usuario.usuarioservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

     @Autowired
    private UsuarioService usuarioService;

     @Autowired
     private CalificacionService calificacionService;


     @PostMapping
     public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuarioRequest){
         Usuario usuario= usuarioService.saveUser(usuarioRequest);
         return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
      }

      @GetMapping
    public ResponseEntity<List<Usuario>> getUsers(){
         return ResponseEntity.ok().body(usuarioService.getUsers());
      }

      @GetMapping("/{idUser}")
    public ResponseEntity<Usuario> getUser(@PathVariable String idUser){
         return ResponseEntity.ok().body(usuarioService.getUsuario(idUser));
      }

    @PostMapping("/feiht")
    public ResponseEntity<CalificacionTrama> guardarCalificacionFeigh(@RequestBody CalificacionTrama calificacionTrama){
        System.out.println("llego " + calificacionTrama);
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.guardarCalificacionTrama(calificacionTrama));
    }
}
