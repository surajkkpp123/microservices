package com.suraj.ratingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ratings")
public class Rating {
    @Id
    private String ratingId = UUID.randomUUID().toString();
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}