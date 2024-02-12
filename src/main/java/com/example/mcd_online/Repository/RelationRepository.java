package com.example.mcd_online.Repository;

import java.util.List;

import org.springframework.data.repository.Repository;
import com.example.mcd_online.Entity.*;

public interface RelationRepository extends Repository<Relation, Integer> {

    Relation save(Relation relation);

    Relation findById(Integer id);

    List<Relation> findAll();

    List<Relation> findByMcd(Mcd mcd);

}
