package com.usersite.dao;

import com.usersite.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> users = entityManager.createQuery("from User", User.class);
        return users.getResultList();
    }

    @Override
    public void saveUser(User user) {
        //entityManager.persist(user); почему не работает?
        entityManager.merge(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteById(int id) {
        Query q =entityManager.createQuery("delete from User u where u.id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
    }
}
