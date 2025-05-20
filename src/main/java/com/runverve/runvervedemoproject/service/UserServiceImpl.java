package com.runverve.runvervedemoproject.service;

import com.runverve.runvervedemoproject.model.User;
import com.runverve.runvervedemoproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public Optional<User> getUserByUserMail(String userMail) {
//        return userRepository.findByUserMailIgnoreCase(userMail);
//    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String userMail) {
        return userRepository.findByUserMailIgnoreCase(userMail);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);  // This returns Optional<User>
    }
}
