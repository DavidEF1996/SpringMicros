package com.hoteles.microhoteles.service.implementacion;

import com.hoteles.microhoteles.entity.Hotel;
import com.hoteles.microhoteles.exceptions.ResourceNotFoundException;
import com.hoteles.microhoteles.repository.HotelRepository;
import com.hoteles.microhoteles.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServicioImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel saveHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }



    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String userId) {
        return hotelRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("Hotel no encontrado con el id: " + userId)
        );
    }


}
