package com.flohmarkt.fm.controller;

import com.flohmarkt.fm.entities.Platz;
import com.flohmarkt.fm.entities.User;
import com.flohmarkt.fm.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;




@RestController
@RequestMapping("/user")
@AllArgsConstructor


public class UserController {
    private final UserService userService;

    @PostMapping("/hinzufuegen/{userName}")
    public ResponseEntity <User>  userHinzufügen(@RequestBody User user){
        return new ResponseEntity<User>(userService.userHinzufuegen(user),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity <User> userPeIdFinden(@PathVariable Integer id){
        return new ResponseEntity<User>(userService.userPerIDFinden(id), HttpStatus.OK);

    }
    @PutMapping
    public ResponseEntity<User> userIdÄndern(User user){

      return new ResponseEntity<User>(userService.userIdÄndern(user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> userÄndern(@RequestBody User user){
        userIdÄndern(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
