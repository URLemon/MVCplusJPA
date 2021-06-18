package com.usersite.dao;

import com.usersite.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    User findById(int id);
    void deleteById(int id);
}
