package com.example.mcd_online.Service;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Attribut;
import com.example.mcd_online.Repository.AttributRepository;
import com.example.mcd_online.Repository.EntiteRepository;

@Service
public class AttributService {

    private AttributRepository attr_repo;
    private EntiteRepository entity_repo;

    public AttributService(AttributRepository attr_repo, EntiteRepository entity_repo) {

        this.attr_repo = attr_repo;
        this.entity_repo = entity_repo;
    }

    public Attribut storeAttribut(String name, boolean is_primary, String id_entite) {
        Attribut attribut = new Attribut();
        attribut.setName(name);
        attribut.setIsPrimary(is_primary);
        attribut.setEntite(this.entity_repo.findById(Integer.parseInt(id_entite)));
        this.attr_repo.save(attribut);
        return attribut;
    }

    public Integer deleteAttribut(String id) {
        Integer id_attribut = Integer.parseInt(id);
        Integer ppkey = id_attribut;
        Attribut attribut = this.attr_repo.findById(ppkey);
        this.attr_repo.deleteById(ppkey);
        return attribut.getId();
    }

}
