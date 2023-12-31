package com.hotel.dao;

import com.hotel.entity.User;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public User findUserByEmail(String email) {
        Query<User> query = currentSession().createQuery("from User where user_email=:UEmail", User.class);
        query.setParameter("uEmail", email);

        User user = null;
        try{
            user = query.getSingleResult();
        }catch(Exception e){
            user = null;
        }
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        Query<User> query = currentSession().createQuery("from User where user_username=:uName", User.class);
        query.setParameter("uName", username);

        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    @Override
    public void saveUser(User theUser) {
        currentSession().saveOrUpdate(theUser);
    }

    private Session currentSession(){
        return entityManager.unwrap(Session.class);
    }
}
