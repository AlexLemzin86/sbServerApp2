package com.javamentor.sbcrudex.dao;


import com.javamentor.sbcrudex.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role getRoleName(String name) {
        TypedQuery<Role> query = entityManager.createQuery("from Role where name = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
