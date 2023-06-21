package com.suraj.hotel.service.hotelservice.service;

import com.suraj.hotel.service.hotelservice.model.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel getHotel(String hotelId);
    List<Hotel> getHotels();
}