package com.example.mcd_online.Service;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Mcd;
import com.example.mcd_online.Repository.McdRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Service
public class McdService {
    private EntityManagerFactory emf;
    private EntityManager em;
    private McdRepository mcdRepo;

    public McdService(McdRepository mcdrepo) {
        this.emf = Persistence.createEntityManagerFactory("H2DB");
        this.em = emf.createEntityManager();
        this.mcdRepo = mcdrepo;

    }

    public UUID generateBlankMcd(String mcd_name) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Mcd mcd = new Mcd();
        mcd.setName(mcd_name);
        mcd.setDescription("mcd");
        mcd.setDate_created(timestamp);
        mcd.setDate_modified(timestamp);
        mcd.setSlug(this.generateSlugFromName(mcd.getName()));
        mcd.setUuid(this.generateUID());
        mcdRepo.save(mcd);
        /*
         * this.em.getTransaction().begin();
         * this.em.persist(mcd);
         * this.em.getTransaction().commit();
         */

        return mcd.getUuid();
    }

    protected String generateSlugFromName(String nString) {
        String slug = nString.toLowerCase().replaceAll(" ", "-");
        return slug;
    }

    protected UUID generateUID() {
        UUID uuid = UUID.randomUUID();
        return uuid;
    }
}
