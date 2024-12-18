package com.example.springboot.dao;

import com.example.springboot.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getListUsers();

    User getUser(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
