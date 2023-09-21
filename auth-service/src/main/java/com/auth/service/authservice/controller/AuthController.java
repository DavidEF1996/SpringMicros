package com.auth.service.authservice.controller;

import com.auth.service.authservice.dto.AuthUserDto;
import com.auth.service.authservice.dto.TokenDto;
import com.auth.service.authservice.entity.AuthUser;
import com.auth.service.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    ResponseEntity<TokenDto> login (@RequestBody AuthUserDto userDto){
        TokenDto recibir = authService.login(userDto);
        if(recibir != null){
            return ResponseEntity.ok(recibir);
        }else{
            return ResponseEntity.badRequest().build();
        }

    }


    @PostMapping("/validate")
    ResponseEntity<TokenDto> validar (@RequestParam String token){
        System.out.println("Estoy llegando");
      TokenDto recibir =   authService.validate(token);
      if(recibir != null){
          return ResponseEntity.ok(recibir);
      }else{
          return ResponseEntity.badRequest().build();
      }

    }



    @PostMapping("/create")
    ResponseEntity<AuthUser> crearUsuario (@RequestBody AuthUserDto authUserDto){
        AuthUser recibir = authService.save(authUserDto);

        if(recibir!= null){
            return ResponseEntity.ok(recibir);

        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
