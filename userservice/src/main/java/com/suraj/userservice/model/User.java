package com.suraj.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="micro_users")
public class User {
    @Id
    private String userId = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String about;
    @Transient
    private List<Rating> ratings = new ArrayList<>();
}