package com.javamentor.sbcrudex.service;

import com.javamentor.sbcrudex.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    int deleteUser(int id);

    List<User> getAllUsers();

    User getUserById(int id);
}
