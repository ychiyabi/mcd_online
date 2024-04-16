package com.example.mcd_online.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "relation")
public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String cardinality_one;
    private String cardinality_two;
    private Integer id_entity_one;
    private Integer id_entity_two;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "entity_one", nullable = false)
    private Entite entity_one;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "entity_two", nullable = false)
    private Entite entity_two;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "mcd", nullable = false)
    private Mcd mcd;

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

    public String getCardinality_one() {
        return cardinality_one;
    }

    public void setCardinality_one(String cardinality_one) {
        this.cardinality_one = cardinality_one;
    }

    public String getCardinality_two() {
        return cardinality_two;
    }

    public void setCardinality_two(String cardinality_two) {
        this.cardinality_two = cardinality_two;
    }

    @JsonProperty("entity_one")
    public Entite getEntity_one() {
        return entity_one;
    }

    public void setEntity_one(Entite entity_one) {
        this.entity_one = entity_one;
    }

    @JsonProperty("entity_two")
    public Entite getEntity_two() {
        return entity_two;
    }

    public void setEntity_two(Entite entity_two) {
        this.entity_two = entity_two;
    }

    public Integer getIdEntityOne() {
        this.id_entity_one = entity_one.getId();
        return id_entity_one;
    }

    public void setIdEntityOne(Integer id_entity_one) {
        this.id_entity_one = id_entity_one;
    }

    public Integer getIdEntityTwo() {
        this.id_entity_two = entity_two.getId();
        return id_entity_two;
    }

    public void setIdEntityTwo(Integer id_entity_two) {
        this.id_entity_two = id_entity_two;
    }

    public Mcd getMcd() {
        return mcd;
    }

    public void setMcd(Mcd mcd) {
        this.mcd = mcd;
    }

}
