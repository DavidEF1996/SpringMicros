package com.hoteles.microhoteles.controllers;

import com.hoteles.microhoteles.entity.Hotel;
import com.hoteles.microhoteles.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {


    @Autowired
    private HotelService hotelService;


    @PostMapping
    public ResponseEntity<Hotel> saveHotel (@RequestBody Hotel hotelRequest){
        Hotel hotel = hotelService.saveHotel(hotelRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels (){
        return ResponseEntity.ok().body(hotelService.getHotels());
    }

    @GetMapping("/{idHotel}")
    public ResponseEntity<Hotel> getHotel (@PathVariable String idHotel){
        return ResponseEntity.ok().body(hotelService.getHotel(idHotel));
    }
}
