package com.flohmarkt.fm.controller;

import com.flohmarkt.fm.entities.UserEntity;
import com.flohmarkt.fm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@AllArgsConstructor


public class UserController {
    private final UserService userService;

    @PostMapping("/hinzufuegen")
    public ResponseEntity <UserEntity>  userHinzufügen(@RequestBody UserEntity user){
        return new ResponseEntity<UserEntity>(userService.userHinzufuegen(user),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity <UserEntity> userPeIdFinden(@PathVariable Integer id){
        return new ResponseEntity<UserEntity>(userService.userPerIDFinden(id), HttpStatus.OK);

    }
    @PutMapping
    public ResponseEntity<UserEntity> userIdÄndern(UserEntity user){

      return new ResponseEntity<UserEntity>(userService.userIdÄndern(user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> userÄndern(@RequestBody UserEntity user){
        userIdÄndern(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
