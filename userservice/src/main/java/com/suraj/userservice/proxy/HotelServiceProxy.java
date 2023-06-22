package com.suraj.userservice.proxy;

import com.suraj.userservice.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("hotel-service")
public interface HotelServiceProxy {
    @GetMapping("/{hotelId}")
    ResponseEntity<Hotel> getHotel(@PathVariable String hotelId);
}