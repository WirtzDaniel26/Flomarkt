package com.flohmarkt.fm.service;

import com.flohmarkt.fm.entities.Platz;
import com.flohmarkt.fm.exeception.EntityNotFoundException;
import com.flohmarkt.fm.repo.UserRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.flohmarkt.fm.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;
    List<User> usrListe = new ArrayList<User>();
    public User userHinzufuegen(User user){
        return  userRepo.save(user);
    }
    public User userPerIDFinden(Integer id){
        return unwrap(userRepo.findById(id),id);
    }



    public User userIdÄndern(User user){
        User tempUser = unwrap(userRepo.findById(user.getId()), user.getId());
        tempUser.setAnschrift(user.getAnschrift());
        tempUser.setEmail(user.getEmail());
        tempUser.setTelefonnummer(user.getTelefonnummer());
        tempUser.setName(user.getName());
        return userRepo.save(tempUser);
    }
    public static User unwrap(Optional<User> user , Integer id){
        if (user.isPresent()){
            return user.get();

        }else{
            throw new EntityNotFoundException(id, user.getClass());
        }
    }
}

