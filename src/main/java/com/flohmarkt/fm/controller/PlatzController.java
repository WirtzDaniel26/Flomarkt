package com.flohmarkt.fm.controller;

import com.flohmarkt.fm.entities.Platz;
import com.flohmarkt.fm.service.PlatzService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/plaetze") // localhost:8080/plaetze
public class PlatzController {
    private final PlatzService platzService;
    @GetMapping("/all")
    public ResponseEntity<List<Platz>> allePlaetze(){return new ResponseEntity<>(platzService.allePleatze(), HttpStatus.OK);}

    @PostMapping("/reservieren/{platzNr}/{platzLaenge}")
    public ResponseEntity<Platz> platzHinzufügenPath(@PathVariable Integer platzNr, Double platzLaenge) {
        return new ResponseEntity<>(platzService.platzHinzufuegenParam(platzNr, platzLaenge), HttpStatus.CREATED);
    }

    @PostMapping("/hinzufuegen")
    public ResponseEntity<Platz> platzHinzufuegenReqBody(@RequestBody Platz platz){
        return new ResponseEntity<Platz>(platzService.platzHinzufügen(platz), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Platz> platzPeIdFinden(@PathVariable Integer id){
        return new ResponseEntity<Platz>(platzService.platzPerIdFinden(id) , HttpStatus.OK);
    }


    @PutMapping("/ändern/{id}")
    public ResponseEntity<Platz> platzÄndern(@RequestBody Platz platz, @PathVariable Integer id){
        return new ResponseEntity<Platz>(platzService.platzÄndern(platz, id), HttpStatus.OK);
    }

    public ResponseEntity<?> platLöschen(@PathVariable Integer id){
        platzService.platzLöschen(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deletePlatz(@PathVariable Integer id) {
        platzService.platzLöschen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
