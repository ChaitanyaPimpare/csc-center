package com.chaitanya.csc_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chaitanya.csc_center.model.User;
import com.chaitanya.csc_center.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // ✅ Register a new user (you can add validation here)
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // ✅ Login verification logic
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }
}
