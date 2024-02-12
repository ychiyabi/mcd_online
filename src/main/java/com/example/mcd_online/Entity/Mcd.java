package com.example.mcd_online.Entity;

import java.rmi.server.UID;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "mcd")
public class Mcd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String slug;
    private String name;
    private String Description;
    private Timestamp date_created;
    private Timestamp date_modified;
    private UUID uuid;

    @JsonManagedReference
    @OneToMany(mappedBy = "mcd")
    private Set<Entite> entites;

    @JsonManagedReference
    @OneToMany(mappedBy = "mcd")
    private Set<Relation> relations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    public Timestamp getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uid) {
        this.uuid = uid;
    }

    public Set<Entite> getEntites() {
        return entites;
    }

    public void setEntites(Set<Entite> entites) {
        this.entites = entites;
    }

    public Set<Relation> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relation> relations) {
        this.relations = relations;
    }

}
