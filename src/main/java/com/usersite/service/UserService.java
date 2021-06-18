package com.usersite.service;

import com.usersite.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    User findById(int id);
    void deleteById(int id);
}
