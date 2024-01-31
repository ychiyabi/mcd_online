package com.example.mcd_online.Entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "entite")
public class Entite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "entite")
    private Set<Attribut> attributs;

    @OneToMany(mappedBy = "entity_one")
    private Set<Relation> relations;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "mcd", nullable = false)
    private Mcd mcd;

    public Set<Attribut> getAttributs() {
        return attributs;
    }

    public void setAttributs(Set<Attribut> attributs) {
        this.attributs = attributs;
    }

    public Set<Relation> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relation> relations) {
        this.relations = relations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Mcd getMcd() {
        return mcd;
    }

    public void setMcd(Mcd mcd) {
        this.mcd = mcd;
    }

}
