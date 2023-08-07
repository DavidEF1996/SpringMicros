package com.mongo.service.mongoMicro.services.implementacion;

import com.mongo.service.mongoMicro.entity.Calificacion;
import com.mongo.service.mongoMicro.repository.CalificacionRepository;
import com.mongo.service.mongoMicro.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public Calificacion create(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> getCalificaciones() {
        return calificacionRepository.findAll();
    }

    @Override
    public List<Calificacion> getCalificacionesByUsuarioId(String usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionesByHotel(String hotelId) {
        return calificacionRepository.findByHotelId(hotelId);
    }
}
