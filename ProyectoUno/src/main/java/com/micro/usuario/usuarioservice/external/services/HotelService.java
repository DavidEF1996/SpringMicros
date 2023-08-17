package com.micro.usuario.usuarioservice.external.services;


import com.micro.usuario.usuarioservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hoteles/{hotelesId}")
    Hotel getHotel (@PathVariable String hotelesId);
}
