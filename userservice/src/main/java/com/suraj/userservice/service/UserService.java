package com.suraj.userservice.service;

import com.suraj.userservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getUsers();
    User getUser(String userId);
    //TODO: delete
    //TODO: update
}
