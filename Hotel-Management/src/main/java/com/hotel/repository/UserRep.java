package com.hotel.repository;

import com.hotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRep extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUsername(String username);

}
