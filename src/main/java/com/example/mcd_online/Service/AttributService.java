package com.example.mcd_online.Service;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Attribut;
import com.example.mcd_online.Entity.Entite;
import com.example.mcd_online.Entity.Relation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Service
public class AttributService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public AttributService() {
        this.emf = Persistence.createEntityManagerFactory("H2DB");
        this.em = emf.createEntityManager();
    }

    public Attribut storeAttribut(String name, boolean is_primary, String id_entite) {
        Attribut attribut = new Attribut();
        attribut.setName(name);
        attribut.setIsPrimary(is_primary);
        attribut.setEntite(this.em.find(Entite.class, Integer.parseInt(id_entite)));
        this.em.getTransaction().begin();
        this.em.persist(attribut);
        this.em.getTransaction().commit();
        return attribut;
    }

    public Integer deleteAttribut(String id) {
        Integer id_attribut = Integer.parseInt(id);
        Integer ppkey = id_attribut;
        Attribut attribut = this.em.find(Attribut.class, ppkey);
        this.em.getTransaction().begin();
        this.em.remove(attribut);
        this.em.getTransaction().commit();
        return attribut.getId();
    }

}
