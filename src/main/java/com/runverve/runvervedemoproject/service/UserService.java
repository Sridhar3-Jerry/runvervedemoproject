package com.runverve.runvervedemoproject.service;

import  com.runverve.runvervedemoproject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    //    Optional<User> getUserByUserMail(String userMail);
    void saveUser(User user);

    Optional<User> getUserByEmail(String userMail);


    Optional<User> getUserById(Long currentUserId);
}
