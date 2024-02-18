package com.example.mcd_online.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.mcd_online.Entity.Entite;
import com.example.mcd_online.Entity.Mcd;
import com.example.mcd_online.Entity.Relation;
import com.example.mcd_online.Repository.EntiteRepository;
import com.example.mcd_online.Repository.McdRepository;
import com.example.mcd_online.Repository.RelationRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Service
public class RelationService {

    private RelationRepository relationRepo;
    private EntiteRepository entiteRepo;
    private McdRepository mcdrepo;
    private EntityManagerFactory emf;
    private EntityManager em;

    public RelationService(RelationRepository relationrepo, EntiteRepository entiterepo, McdRepository mcdrepo) {
        this.relationRepo = relationrepo;
        this.entiteRepo = entiterepo;
        this.mcdrepo = mcdrepo;
        this.emf = Persistence.createEntityManagerFactory("H2DB");
        this.em = emf.createEntityManager();
    }

    public Relation storeRelation(String name, String entity_one, String entity_two, String car_one, String car_two,
            String mcd_uid) {
        UUID uid = UUID.fromString(mcd_uid);
        Mcd main_mcd = this.mcdrepo.findByUuid(uid);
        Relation relation = new Relation();
        relation.setName(name);
        relation.setDescription("teste");
        relation.setEntity_one(this.getSpecificEntityById(entity_one));
        relation.setEntity_two(this.getSpecificEntityById(entity_two));
        relation.setCardinality_one(car_one);
        relation.setCardinality_two(car_two);
        relation.setMcd(main_mcd);
        relationRepo.save(relation);
        return relation;
    }

    protected Entite getSpecificEntityById(String id) {
        Entite entity = this.entiteRepo.findById(Integer.parseInt(id));
        return entity;
    }

    public List<Relation> getAllRelationsByMcd(String mcd_uid) {
        UUID uid = UUID.fromString(mcd_uid);
        Mcd main_mcd = this.mcdrepo.findByUuid(uid);
        return relationRepo.findByMcd(main_mcd);
    }

    public Integer deleteRelation(String id) {
        Integer id_relation = Integer.parseInt(id);
        Integer ppkey = id_relation;
        Relation relation = this.em.find(Relation.class, ppkey);
        this.em.getTransaction().begin();
        this.em.remove(relation);
        this.em.getTransaction().commit();
        return relation.getId();
    }

}
