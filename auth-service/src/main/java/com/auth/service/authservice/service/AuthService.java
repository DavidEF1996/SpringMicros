package com.auth.service.authservice.service;

import com.auth.service.authservice.dto.AuthUserDto;
import com.auth.service.authservice.dto.NewUserDto;
import com.auth.service.authservice.dto.RequestDto;
import com.auth.service.authservice.dto.TokenDto;
import com.auth.service.authservice.entity.AuthUser;
import com.auth.service.authservice.repository.AuthServiceRepository;
import com.auth.service.authservice.security.JwtProvider;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {


    @Autowired
    private AuthServiceRepository authServiceRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public AuthUser save(NewUserDto authUserDto){
        Optional <AuthUser> authUser = authServiceRepository.findByUserName(authUserDto.getUserName());

        if(authUser.isPresent()){
            return null;
        }

        String password = passwordEncoder.encode(authUserDto.getPassword());

        AuthUser auth =  AuthUser.builder()
                .userName(authUserDto.getUserName())
                .password(password)
                .role(authUserDto.getRole())
                .build();
        return authServiceRepository.save(auth);
    }


    public TokenDto login ( AuthUserDto authUserDto ){
        Optional <AuthUser> authUser = authServiceRepository.findByUserName(authUserDto.getUserName());
        if(authUser==null){
            return  null;
        }

       String passordRaw = authUserDto.getPassword();
       String passwordEncript = authUser.get().getPassword();

        System.out.println(passordRaw + " " + passwordEncript);
        if(passwordEncoder.matches(authUserDto.getPassword(), passwordEncript)){
            authUser.get().getPassword();
            return new TokenDto(jwtProvider.createToken(authUser.get()));
        }

        return null;
    }


    public TokenDto validate (String token, RequestDto requestDto){
        if(!jwtProvider.validateToken(token, requestDto)){
            return null;
        }

        String userName = jwtProvider.userNameFromToken(token);

        if(!authServiceRepository.findByUserName(userName).isPresent()){
            return null;
        }

        return new TokenDto(token);
    }
}
