package com.example.mcd_online.Service;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Attribut;
import com.example.mcd_online.Entity.Entite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Service
public class AttributService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public AttributService(){
        this.emf=Persistence.createEntityManagerFactory("H2DB");
        this.em=emf.createEntityManager();
    }

    public void storeAttribut(String name,String type,Integer id_entite){
        Attribut attribut=new Attribut();
        attribut.setName(name);
        attribut.setType(type);
        attribut.setEntite(this.em.find(Entite.class, id_entite));
        this.em.getTransaction().begin();
        this.em.persist(attribut);
        this.em.getTransaction().commit();
    }

    public void retreiveSpecificAttribut(){
        
    }
    
}
