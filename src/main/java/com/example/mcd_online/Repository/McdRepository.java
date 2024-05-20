package com.example.mcd_online.Repository;

import org.springframework.data.repository.Repository;
import com.example.mcd_online.Entity.*;

import java.util.List;
import java.util.UUID;

public interface McdRepository extends Repository<Mcd, Integer> {
    Mcd findByUuid(UUID uuid);

    Mcd save(Mcd mcd);

    List<Mcd> findAll();

    List<Mcd> findByUser(User user);
}
