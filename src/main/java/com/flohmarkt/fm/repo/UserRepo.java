package com.flohmarkt.fm.repo;

import com.flohmarkt.fm.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity,Integer> {
}
