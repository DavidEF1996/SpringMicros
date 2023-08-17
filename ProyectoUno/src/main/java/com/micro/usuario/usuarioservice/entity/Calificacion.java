package com.micro.usuario.usuarioservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {

    private String calificacionesId;

    private String usuarioId;

    private String hotelId;

    private String observaciones;

    private int calificaciones;

    private Hotel hotel;
}
