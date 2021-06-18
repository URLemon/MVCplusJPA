package com.usersite.service;

import com.usersite.dao.UserDao;
import com.usersite.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao dao;

    public UserServiceImpl(UserDao dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    @Transactional
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
