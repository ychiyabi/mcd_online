package com.example.mcd_online.Service;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Entite;
import com.example.mcd_online.Entity.Relation;
import com.example.mcd_online.Repository.EntiteRepository;
import com.example.mcd_online.Repository.RelationRepository;

@Service
public class RelationService {

    private RelationRepository relationRepo;
    private EntiteRepository entiteRepo;

    public RelationService(RelationRepository relationrepo, EntiteRepository entiterepo) {
        this.relationRepo = relationrepo;
        this.entiteRepo = entiterepo;

    }

    public Relation storeRelation(String name, String entity_one, String entity_two, String car_one, String car_two) {
        Relation relation = new Relation();
        relation.setName(name);
        relation.setDescription("teste");
        relation.setEntity_one(this.getSpecificEntityById(entity_one));
        relation.setEntity_two(this.getSpecificEntityById(entity_two));
        relation.setCardinality_one(car_one);
        relation.setCardinality_two(car_two);
        relationRepo.save(relation);
        return relation;
    }

    protected Entite getSpecificEntityById(String id) {
        Entite entity = this.entiteRepo.findById(Integer.parseInt(id));
        return entity;
    }

}
