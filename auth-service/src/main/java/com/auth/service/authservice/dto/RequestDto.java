package com.auth.service.authservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDto {

     //se agrega la url del servicio y el metodo post, put, etc
     private String uri;
     private String method;
}
