package com.example.mcd_online.Entity;

import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String token;
    private Timestamp date_join;
    private Timestamp last_access;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Mcd> mcds;

    public Set<Mcd> getMcds() {
        return mcds;
    }

    public void setMcds(Set<Mcd> mcds) {
        this.mcds = mcds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getDate_join() {
        return date_join;
    }

    public void setDate_join(Timestamp date_join) {
        this.date_join = date_join;
    }

    public Timestamp getLast_access() {
        return last_access;
    }

    public void setLast_access(Timestamp last_access) {
        this.last_access = last_access;
    }

}
