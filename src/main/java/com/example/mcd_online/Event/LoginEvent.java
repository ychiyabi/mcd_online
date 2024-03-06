package com.example.mcd_online.Event;

import org.springframework.context.ApplicationEvent;

public class LoginEvent extends ApplicationEvent {

    private String email;
    private String token;

    public LoginEvent(Object source, String email, String token) {
        super(source);
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
