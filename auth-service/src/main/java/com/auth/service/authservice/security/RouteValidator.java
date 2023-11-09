package com.auth.service.authservice.security;

import com.auth.service.authservice.dto.RequestDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
@ConfigurationProperties(prefix = "admin-paths")
public class RouteValidator {
//ESTA CLASE SIRVE para que segun la config de los properties, solos los admis puedan acceder
    private List<RequestDto> paths; // lista que contiene los paths para admins

    public List<RequestDto> getPaths() {
        return paths;
    }

    public void setPaths(List<RequestDto> paths) {
        this.paths = paths;
    }


    public boolean isAdmin(RequestDto dto){
        //recorre los paths y compara, si coincide las uris y el metodo, quiere decir que es admin
        return paths.stream().anyMatch(p-> Pattern.matches(p.getUri(), dto.getUri())&& dto.getMethod().equals(p.getMethod()));
    }



}


