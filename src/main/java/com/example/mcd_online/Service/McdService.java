package com.example.mcd_online.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Mcd;
import com.example.mcd_online.Entity.User;
import com.example.mcd_online.Repository.McdRepository;
import com.example.mcd_online.Repository.UserRepository;

@Service
public class McdService {
    private McdRepository mcdRepo;
    private UserRepository userRepo;

    public McdService(McdRepository mcdrepo, UserRepository userRepo) {
        this.mcdRepo = mcdrepo;
        this.userRepo = userRepo;

    }

    public UUID generateBlankMcd(String mcd_name, String email) {
        User user = userRepo.findByEmail(email);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Mcd mcd = new Mcd();
        mcd.setName(mcd_name);
        mcd.setDescription("mcd");
        mcd.setDate_created(timestamp);
        mcd.setDate_modified(timestamp);
        mcd.setSlug(this.generateSlugFromName(mcd.getName()));
        mcd.setUuid(this.generateUID());
        mcd.setUser(user);
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

    public List<Mcd> listOfMcd(String email) {
        User user = userRepo.findByEmail(email);
        List<Mcd> myList = mcdRepo.findByUser(user);
        return myList;
    }
}
