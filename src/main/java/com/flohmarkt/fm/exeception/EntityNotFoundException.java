package com.flohmarkt.fm.exeception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Integer id, Class <?> c){
        super(c.getSimpleName()+"ID "+id+"nicht gefunden");
    }
}
