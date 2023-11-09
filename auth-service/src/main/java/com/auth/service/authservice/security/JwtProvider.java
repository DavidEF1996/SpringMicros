package com.auth.service.authservice.security;


import com.auth.service.authservice.dto.RequestDto;
import com.auth.service.authservice.entity.AuthUser;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
@Component
public class JwtProvider {

    //Llave secreta que irá en  el token
    @Value("${jwt.secret}")
    private String secret;

    //Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);



    @Autowired
    private RouteValidator routeValidator;

    //metodo inicial que se lanzará cuando se cree la instancia de la clase y que codificara en base 64 y guardar en la variable secret la llave
    @PostConstruct
    protected  void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }


    public String createToken(AuthUser authUser){
        Map<String, Object> claims = new HashMap<>();
        claims = Jwts.claims().setSubject(authUser.getUserName());
        claims.put("id",authUser.getId());
        claims.put("role", authUser.getRole());
        Date now = new Date();
        Date exp = new Date(now.getTime() + 3600000);
        System.out.println("secret: " + secret);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }



    public boolean validateToken (String token, RequestDto requestDto){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

        }catch (Exception e){
            System.out.println(e.getMessage());
                return false;
        }
    if(!isAdmin(token)&& routeValidator.isAdmin(requestDto)){
        return false;
    }

    return true;

    }


    public String userNameFromToken ( String token){
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        }catch (Exception e){
            return "Bad subject";
        }
    }


    private boolean isAdmin(String token){
        return (Jwts.parser().setSigningKey(secret)).parseClaimsJws(token).getBody().get("role").equals("admin");
    }
}
