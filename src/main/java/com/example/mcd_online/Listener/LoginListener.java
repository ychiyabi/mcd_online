package com.example.mcd_online.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.mcd_online.Event.LoginEvent;
import com.example.mcd_online.Service.UserService;

@Component
public class LoginListener implements ApplicationListener<LoginEvent> {

    @Autowired
    UserService service;

    @Override
    public void onApplicationEvent(LoginEvent event) {
        service.loginHandler(event.getEmail(), event.getToken());
    }
}
