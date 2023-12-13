package com.flohmarkt.fm.repo;

import com.flohmarkt.fm.entities.Platz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatzRepo extends CrudRepository<Platz,Integer> {

}
