package com.javamentor.sbcrudex.service;

import com.javamentor.sbcrudex.dao.RoleDAO;
import com.javamentor.sbcrudex.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public Role getRoleName(String name) {
        return roleDAO.getRoleName(name);
    }
}
