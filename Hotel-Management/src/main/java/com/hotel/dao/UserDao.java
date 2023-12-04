package com.hotel.dao;

import com.hotel.entity.User;

public interface UserDao {
    public User findUserByEmail(String email);

    public User findUserByUsername(String username);

    public void saveUser(User user);
}
