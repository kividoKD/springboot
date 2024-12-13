package com.example.springboot.service;

import com.example.springboot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getListUsers();

    User getUser(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
