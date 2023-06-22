package com.suraj.userservice.proxy;

import com.suraj.userservice.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="rating-service")
public interface RatingServiceProxy {
    @GetMapping("/users/{userId}")
    ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId);
}