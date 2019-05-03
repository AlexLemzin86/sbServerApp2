package com.javamentor.sbcrudex.service;

import com.javamentor.sbcrudex.dao.UserDAO;
import com.javamentor.sbcrudex.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User addUser(User user) {
        this.userDAO.addUser(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        this.userDAO.updateUser(user);
        return user;
    }

    @Override
    @Transactional
    public int deleteUser(int id) {
       return this.userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }
}
