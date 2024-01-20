package com.example.mcd_online.Service;

import com.example.mcd_online.Entity.Entite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityService {

    private EntityManagerFactory emf;
    private EntityManager em;
    public EntityService(){
        this.emf=Persistence.createEntityManagerFactory("H2DB");
        this.em=emf.createEntityManager();
    }

    public Integer insertEntite(){
        Entite entity=new Entite();
        entity.setName("teste");
        entity.setDescription("teste");
        this.em.getTransaction().begin();
        this.em.persist(entity);
        this.em.getTransaction().commit();
        
        return entity.getId();
    }

    public Entite getEntity(Integer id){
        
        Integer ppkey=id;
        Entite entity=this.em.find(Entite.class, ppkey);
        try{
            this.em.close();
            this.emf.close();
            return entity;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
