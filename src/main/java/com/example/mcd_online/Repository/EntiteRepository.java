package com.example.mcd_online.Repository;

import org.springframework.data.repository.Repository;
import com.example.mcd_online.Entity.*;
import java.util.List;

public interface EntiteRepository extends Repository<Entite, Integer> {

  Entite save(Entite entite);

  Entite findById(Integer id);

  Entite deleteById(Integer id);

  List<Entite> findByMcd(Mcd mcd);
}