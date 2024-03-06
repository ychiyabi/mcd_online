package com.example.mcd_online.Repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.mcd_online.Entity.User;

public interface UserRepository extends Repository<User, Integer> {

    User save(User user);

    User findByEmail(String email);

    List<User> findAll();

}
