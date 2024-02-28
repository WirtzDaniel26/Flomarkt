package com.flohmarkt.fm.service;

import com.flohmarkt.fm.entities.Reservierung;
import com.flohmarkt.fm.entities.UserEntity;
import com.flohmarkt.fm.exeception.EntityNotFoundException;
import com.flohmarkt.fm.repo.ReservierungsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservierungsService {
    private ReservierungsRepo reservierungsRepo;
    List<Reservierung> reservierungList = new ArrayList<>();

    public List<Reservierung> alleReservierung() {
        return reservierungList;
    }

    public List<Reservierung> alleReservierungen() {
        return (List<Reservierung>) reservierungsRepo.findAll();
    }

    public Reservierung reservierungHinzufügen(Reservierung reservierung) {
        return reservierungsRepo.save(reservierung);
    }

    public Reservierung reservierungFinden(Integer id) {
        for (Reservierung r : reservierungList) {
            if (Objects.equals(r.getId(), id)) {
                return r;
            }
        }
        return new Reservierung();
    }

    public Reservierung reservierungÄndern(Reservierung reservierung, Integer id) {
        Reservierung tempReservierung = unwrap(reservierungsRepo.findById(Long.valueOf(id)), id);
        tempReservierung.setId(reservierung.getId());
        tempReservierung.setUser(reservierung.getUser());
        tempReservierung.setZeit(reservierung.getZeit());

        return reservierungsRepo.save(tempReservierung);
    }

    public static Reservierung unwrap(Optional<Reservierung> reservierung, Integer id) {
        if (reservierung.isPresent()) {
            return reservierung.get();
        } else {
            throw new EntityNotFoundException(id, reservierung.getClass());
        }
    }

    public void reservierungLöschen(Integer id) {
         reservierungsRepo.delete(unwrap(reservierungsRepo.findById(Long.valueOf(id)), id));
    }

}