package com.example.mcd_online.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Entite;
import com.example.mcd_online.Entity.Mcd;
import com.example.mcd_online.Repository.McdRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Service
public class EntityService {

    private EntityManagerFactory emf;
    private EntityManager em;
    private McdRepository mcdrepo;

    public EntityService(McdRepository mcdrepo) {
        this.emf = Persistence.createEntityManagerFactory("H2DB");
        this.em = emf.createEntityManager();
        this.mcdrepo = mcdrepo;
    }

    public Integer insertEntite(String name, String mcd) {
        UUID uid = UUID.fromString(mcd);
        Mcd main_mcd = this.mcdrepo.findByUuid(uid);
        Entite entity = new Entite();
        entity.setName(name);
        entity.setDescription("teste");
        entity.setMcd(main_mcd);
        this.em.getTransaction().begin();
        this.em.persist(entity);
        this.em.getTransaction().commit();
        return entity.getId();
    }

    public Entite getEntity(Integer id) {

        Integer ppkey = id;
        Entite entity = this.em.find(Entite.class, ppkey);
        try {
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
