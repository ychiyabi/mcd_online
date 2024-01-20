package com.example.mcd_online.Repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;
import com.example.mcd_online.Entity.*;

public interface EntiteRepository extends Repository<Entite, Integer> {

    Entite save(Entite entite);
  
    Entite findById(Integer id);
  }