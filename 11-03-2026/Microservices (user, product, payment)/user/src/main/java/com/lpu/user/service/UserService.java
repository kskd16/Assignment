package com.lpu.user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.user.entity.User;
import com.lpu.user.repo.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }
}