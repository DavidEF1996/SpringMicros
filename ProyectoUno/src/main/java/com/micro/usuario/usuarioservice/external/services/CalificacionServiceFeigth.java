package com.micro.usuario.usuarioservice.external.services;

import com.micro.usuario.usuarioservice.entity.CalificacionTrama;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "CALIFICACION-SERVICE")
public interface CalificacionServiceFeigth {



    @PostMapping("/calificaciones")
    CalificacionTrama guardarCalificacionFeiht (CalificacionTrama calificacion);
}
