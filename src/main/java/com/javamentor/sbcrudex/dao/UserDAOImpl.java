package com.javamentor.sbcrudex.dao;

import com.javamentor.sbcrudex.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(final User user) {
        this.entityManager.persist(user);
    }

    @Override
    public void updateUser(final User user) {
        entityManager.merge(user);
    }

    @Override
    public int deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        this.entityManager.remove(user);
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return this.entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findByUserLogin(String login) {
        TypedQuery<User> query = this.entityManager.createQuery("from User where login = :login", User.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> query = this.entityManager.createQuery("from User where id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
