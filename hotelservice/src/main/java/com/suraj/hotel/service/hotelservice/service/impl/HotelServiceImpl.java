package com.suraj.hotel.service.hotelservice.service.impl;

import com.suraj.hotel.service.hotelservice.exception.ResourceNotFoundException;
import com.suraj.hotel.service.hotelservice.model.Hotel;
import com.suraj.hotel.service.hotelservice.repository.HotelRepository;
import com.suraj.hotel.service.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(
                ()->new ResourceNotFoundException("Hotel not found with hotel id - "+hotelId));
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }
}