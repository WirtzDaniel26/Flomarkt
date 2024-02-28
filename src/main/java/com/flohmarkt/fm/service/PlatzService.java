package com.flohmarkt.fm.service;

import com.flohmarkt.fm.entities.Platz;
import com.flohmarkt.fm.exeception.EntityNotFoundException;
import com.flohmarkt.fm.repo.PlatzRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlatzService {
    private PlatzRepo platzRepo;



    public Platz platzHinzufuegenParam(Integer platzNr, Double platzLaenge){
        return  platzRepo.save(new Platz(platzNr, platzLaenge));
    }

    private void printPltze(){
        List<Platz> platzListe = (List<Platz>) platzRepo.findAll();
        for(Platz p : platzListe){
            System.out.println("Platz " + p.getPlatzNummer());
        }
    }

    public Platz platzHinzufügen(Platz neuerPlatz){
        return platzRepo.save(neuerPlatz);
    }

    public Platz platzPerIdFinden(Integer id){
        return unwrap(platzRepo.findById(id),id);
    }
    public static Platz unwrap(Optional <Platz> platz ,Integer id){
        if (platz.isPresent()){
            return platz.get();

        }else{
            throw new EntityNotFoundException(id, platz.getClass());
        }
    }
    public Platz platzÄndern(Platz platz,Integer id ){
        Platz tempPlatz = unwrap(platzRepo.findById(id),id);
       tempPlatz.setPlatzNummer(platz.getPlatzNummer());
       tempPlatz.setLaenge(platz.getLaenge());

        return platzRepo.save(tempPlatz);
    }

    public void platzLöschen(Integer id){
        platzRepo.delete(unwrap(platzRepo.findById(id),id));
    }

    public List<Platz> allePleatze(){
        return (List<Platz>) platzRepo.findAll();
    }
}
