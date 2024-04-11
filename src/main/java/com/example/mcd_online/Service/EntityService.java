package com.example.mcd_online.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Entite;
import com.example.mcd_online.Entity.Mcd;
import com.example.mcd_online.Repository.EntiteRepository;
import com.example.mcd_online.Repository.McdRepository;

@Service
public class EntityService {

    private McdRepository mcdrepo;
    private EntiteRepository entiterepo;

    public EntityService(McdRepository mcdrepo, EntiteRepository entiterepo) {
        this.mcdrepo = mcdrepo;
        this.entiterepo = entiterepo;
    }

    public Integer insertEntite(String name, String mcd) {
        UUID uid = UUID.fromString(mcd);
        Mcd main_mcd = this.mcdrepo.findByUuid(uid);
        Entite entity = new Entite();
        entity.setName(name);
        entity.setDescription("teste");
        entity.setMcd(main_mcd);
        entiterepo.save(entity);
        return entity.getId();
    }

    public Entite getEntity(Integer id) {

        Integer ppkey = id;
        Entite entity = entiterepo.findById(ppkey);
        try {
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Entite> getEntities(String mcd) {
        UUID uid = UUID.fromString(mcd);
        Mcd main_mcd = this.mcdrepo.findByUuid(uid);
        List<Entite> entities = this.entiterepo.findByMcd(main_mcd);
        try {
            return entities;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer deleteEntity(String id) {
        Integer id_entity = Integer.parseInt(id);
        Integer ppkey = id_entity;
        Entite entity = entiterepo.findById(ppkey);
        entiterepo.deleteById(ppkey);
        return entity.getId();
    }

}
