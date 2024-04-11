package com.example.mcd_online.Service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.User;
import com.example.mcd_online.Repository.UserRepository;

@Service
public class UserService {

    private UserRepository user_repo;
    private Timestamp timestamp;

    public UserService(UserRepository user_repo) {
        this.user_repo = user_repo;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    protected User storeUser(User user) {
        user.setEmail(user.getEmail());
        user.setToken(user.getToken());
        user.setDate_join(this.timestamp);
        user.setLast_access(this.timestamp);
        this.user_repo.save(user);
        return user;
    }

    protected User updateUser(User user) {

        user.setToken(user.getToken());
        user.setLast_access(this.timestamp);
        this.user_repo.save(user);
        return user;

    }

    public User loginHandler(String email, String token) {
        User user = this.user_repo.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setToken(token);
            this.storeUser(user);
        } else {
            this.updateUser(user);
        }

        return user;
    }
}
