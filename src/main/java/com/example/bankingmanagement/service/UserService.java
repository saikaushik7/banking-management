package com.example.bankingmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankingmanagement.entity.User;
import com.example.bankingmanagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Admin will use this to create users
    public User createUser(String username, String password, String role) {
        User user = new User(username, password, role);
        return userRepository.save(user);
    }

    // Used for login (later)
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
