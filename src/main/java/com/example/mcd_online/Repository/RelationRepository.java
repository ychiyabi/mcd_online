package com.example.mcd_online.Repository;

import org.springframework.data.repository.Repository;
import com.example.mcd_online.Entity.*;

public interface RelationRepository extends Repository<Relation, Integer> {

    Relation save(Relation relation);

    Relation findById(Integer id);

}
