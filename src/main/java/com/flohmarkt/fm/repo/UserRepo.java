package com.flohmarkt.fm.repo;

import com.flohmarkt.fm.entities.Platz;
import com.flohmarkt.fm.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
}
