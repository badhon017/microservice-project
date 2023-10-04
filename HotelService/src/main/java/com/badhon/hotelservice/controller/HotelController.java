package com.badhon.hotelservice.controller;

import com.badhon.hotelservice.entities.Hotel;
import com.badhon.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.create(hotel), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllHotels(){
        return new ResponseEntity<>(hotelService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<?> getHotel(@PathVariable String hotelId){
        return new ResponseEntity<>(hotelService.get(hotelId), HttpStatus.OK);
    }
}
