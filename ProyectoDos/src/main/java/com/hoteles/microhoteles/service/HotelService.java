package com.hoteles.microhoteles.service;


import com.hoteles.microhoteles.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel usuario);

    List<Hotel> getHotels();

    Hotel getHotel (String userId);
}
