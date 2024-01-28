package com.example.mcd_online.Repository;

import org.springframework.data.repository.Repository;
import com.example.mcd_online.Entity.*;
import java.util.UUID;

public interface McdRepository extends Repository<Mcd, Integer> {
    Mcd findByUuid(UUID uuid);
}
