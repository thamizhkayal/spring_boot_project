package com.hd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.app.repository.UserRepository;
import com.hd.app.model.User;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<User> getAllUser() {
        return userRepo.findAll();

    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

}
