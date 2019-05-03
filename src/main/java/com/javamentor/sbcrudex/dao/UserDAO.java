package com.javamentor.sbcrudex.dao;

import com.javamentor.sbcrudex.model.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void updateUser(User user);

    int deleteUser(int id);

    List<User> getAllUsers();

    User findByUserLogin(String login);

    User getUserById(int id);
}
