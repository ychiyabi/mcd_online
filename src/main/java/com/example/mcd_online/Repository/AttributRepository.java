package com.example.mcd_online.Repository;

import org.springframework.data.repository.Repository;
import com.example.mcd_online.Entity.*;
import java.util.List;

public interface AttributRepository extends Repository<Attribut, Integer> {

    Attribut save(Attribut attribut);

    Attribut findById(Integer id);

    Attribut deleteById(Integer id);

}