package com.suraj.hotel.service.hotelservice.repository;

import com.suraj.hotel.service.hotelservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {
}
