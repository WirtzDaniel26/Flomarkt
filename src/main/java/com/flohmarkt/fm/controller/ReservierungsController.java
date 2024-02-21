package com.flohmarkt.fm.controller;

import com.flohmarkt.fm.entities.Platz;
import com.flohmarkt.fm.entities.Reservierung;
import com.flohmarkt.fm.service.ReservierungsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/reservierungen")
@AllArgsConstructor

public class ReservierungsController {

    @GetMapping("/all")
    public ResponseEntity<List<Reservierung>> alleReservierungen(){return new ResponseEntity<>(reservierungsService.alleReservierungen(), HttpStatus.OK);}
    private final ReservierungsService reservierungsService;
    @PostMapping("/reservieren")
    public ResponseEntity<Reservierung> neueReservierung(@RequestBody Reservierung reservierung){
        return new ResponseEntity<Reservierung>(reservierungsService.reservierungHinzufügen(reservierung), HttpStatus.CREATED);

    }

    // TODO: PUT (ändern), DELETE
    @DeleteMapping
    public ResponseEntity<?> deleteReservierung(Integer id){
       reservierungsService.reservierungLöschen(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get localhost:8080/reservierungen/{n}
    // ntes Element in der liste finden falls es existiert
    @GetMapping("/reservierungen/{reservierungsNr}")
    public ResponseEntity<Reservierung> reservierungZurückGeben(@PathVariable Integer id){
        return  new ResponseEntity<Reservierung>(reservierungsService.reservierungFinden(id), HttpStatus.OK );
    } // FEHLER FINDEN !
    // TODO: get by id, put

    @PutMapping
    public  ResponseEntity<Reservierung> reservierungÄndern(@RequestBody Reservierung reservierung){
        return  new ResponseEntity<Reservierung>(reservierungsService.reservierungÄndern(reservierung), HttpStatus.OK);
    }
}
