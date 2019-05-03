package com.javamentor.sbcrudex.service;

import com.javamentor.sbcrudex.dao.UserDAO;
import com.javamentor.sbcrudex.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDAO userDAO;

    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.findByUserLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), user.getRoles());
    }
}
