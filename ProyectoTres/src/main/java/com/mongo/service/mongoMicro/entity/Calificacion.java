package com.mongo.service.mongoMicro.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("calificaciones")
public class Calificacion {

    @Id
    private String calificacionesId;
    private String hotelId;
    private String usuarioId;
    private int calificaciones;
    private String observaciones;

}
