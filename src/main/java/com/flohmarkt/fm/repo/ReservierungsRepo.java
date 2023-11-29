package com.flohmarkt.fm.repo;

import com.flohmarkt.fm.entities.Platz;
import com.flohmarkt.fm.entities.Reservierung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservierungsRepo extends CrudRepository<Reservierung,Long> {
}
