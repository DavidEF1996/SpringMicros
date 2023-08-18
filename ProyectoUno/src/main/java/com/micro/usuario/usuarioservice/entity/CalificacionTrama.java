package com.micro.usuario.usuarioservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionTrama {

    private String hotelId;
    private String usuarioId;
    private int calificaciones;
    private String observaciones;

}
