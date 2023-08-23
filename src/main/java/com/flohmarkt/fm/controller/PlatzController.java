package com.flohmarkt.fm.controller;

import com.flohmarkt.fm.entities.Platz;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("plaetze") // localhost:8080/plaetze
public class PlatzController {
    List<Platz> platzListe = new ArrayList<>();
    Integer counter = 0;
    @GetMapping("/all")
    public String allePlaetze(){
        return "ALLE";
    }
//    @PostMapping("add")
//    // rservierungsanfragen ?
    @PostMapping("/reservieren/{platzNr}/{platzLaenge}")
    public void platzHinzufügen(@PathVariable Integer platzNr,Double platzLaenge) {
        platzListe.add(new Platz(platzNr, platzLaenge));

        for(Platz p : platzListe){
            System.out.println("Platz " + p.getPlatzNummer());
        }
    }

    private void printPltze(){
        for(Platz p : platzListe){
            System.out.println("Platz " + p.getPlatzNummer());
        }
    }

    @PostMapping("/hinzufuegen")
    public ResponseEntity<Platz> platzHinzufuegen(@RequestBody Platz platz){
        platzListe.add(platz);
        printPltze();
        return new ResponseEntity<Platz>(HttpStatus.CREATED);
    }
}
