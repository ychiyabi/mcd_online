package com.example.mcd_online.Service;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Mcd;
import com.example.mcd_online.Repository.McdRepository;

@Service
public class McdService {
    private McdRepository mcdRepo;

    public McdService(McdRepository mcdrepo) {
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
