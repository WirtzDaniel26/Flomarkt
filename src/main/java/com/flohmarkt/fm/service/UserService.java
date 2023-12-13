package com.flohmarkt.fm.service;

import com.flohmarkt.fm.exeception.EntityNotFoundException;
import com.flohmarkt.fm.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.flohmarkt.fm.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;
    List<UserEntity> usrListe = new ArrayList<UserEntity>();
    public UserEntity userHinzufuegen(UserEntity user){
        return  userRepo.save(user);
    }
    public UserEntity userPerIDFinden(Integer id){
        return unwrap(userRepo.findById(id),id);
    }



    public UserEntity userIdÄndern(UserEntity user){
        UserEntity tempUser = unwrap(userRepo.findById(user.getId()), user.getId());
        tempUser.setAnschrift(user.getAnschrift());
        tempUser.setEmail(user.getEmail());
        tempUser.setTelefonnummer(user.getTelefonnummer());
        tempUser.setName(user.getName());
        return userRepo.save(tempUser);
    }
    public static UserEntity unwrap(Optional<UserEntity> user , Integer id){
        if (user.isPresent()){
            return user.get();

        }else{
            throw new EntityNotFoundException(id, user.getClass());
        }
    }
}

