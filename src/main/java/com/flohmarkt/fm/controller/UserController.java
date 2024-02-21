package com.flohmarkt.fm.controller;

import com.flohmarkt.fm.entities.Platz;
import com.flohmarkt.fm.entities.UserEntity;
import com.flohmarkt.fm.service.UserService;
import lombok.AllArgsConstructor;
import org.h2.engine.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@AllArgsConstructor


public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> alleUser(){return new ResponseEntity<>(userService.alleUser(), HttpStatus.OK);}
    @PostMapping("/hinzufuegen")
    public ResponseEntity <UserEntity>  userHinzufügen(@RequestBody UserEntity user){
        return new ResponseEntity<UserEntity>(userService.userHinzufuegen(user),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity <UserEntity> userPeIdFinden(@PathVariable Integer id){
        return new ResponseEntity<UserEntity>(userService.userPerIDFinden(id), HttpStatus.OK);

    }

    @PutMapping("ändern/{id}")
    public ResponseEntity<UserEntity> userÄndern(@RequestBody UserEntity user, @PathVariable Integer id){
        return new ResponseEntity<UserEntity>(userService.userÄndern(user, id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userService.userLöschen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
