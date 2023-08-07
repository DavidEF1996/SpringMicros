package com.hoteles.microhoteles.repository;


import com.hoteles.microhoteles.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {


}
