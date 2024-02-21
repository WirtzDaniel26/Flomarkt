package com.flohmarkt.fm.service;

import com.flohmarkt.fm.entities.Reservierung;
import com.flohmarkt.fm.repo.ReservierungsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ReservierungsService {
    private ReservierungsRepo reservierungsRepo;
    List<Reservierung> reservierungList = new ArrayList<>();

    public List<Reservierung>alleReservierung(){return reservierungList;}

    public List<Reservierung> alleReservierungen(){
        return  (List<Reservierung>) reservierungsRepo.findAll();
    }
    public Reservierung  reservierungHinzufügen(Reservierung reservierung){
        return reservierungsRepo.save(reservierung);
    }

    public Reservierung reservierungFinden(Integer id){
        for(Reservierung r : reservierungList){
            if (Objects.equals(r.getId(), id)){
                return r;
            }
        }
        return new Reservierung();
    }

    public Reservierung reservierungÄndern(Reservierung reservierung){
        for(Reservierung r : reservierungList){
            if (r.getId().equals(reservierung.getId())){
                r = reservierung;
                return r;
            }
        }
        return new Reservierung();
    }

    public Reservierung reservierungLöschen(Integer id){
        Reservierung temp = new Reservierung();
        for (Reservierung r : reservierungList){
            if (Objects.equals(r.getId(), id)){
                temp = r;
                reservierungList.remove(r);
            }
        }
        return  temp;
    }
}
