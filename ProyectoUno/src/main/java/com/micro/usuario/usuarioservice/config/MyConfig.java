package com.micro.usuario.usuarioservice.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    //registrar restemplate para inyectarlo y usarlo
    @Bean
    @LoadBalanced
    public RestTemplate restemplate(){
        return new RestTemplate();
    }
}
