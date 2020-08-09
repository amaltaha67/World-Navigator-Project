package com.javatechie.spring.ajax.api.model.objects;


import com.javatechie.spring.ajax.api.model.directors.Directions;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;

public class Room {
    private RoomObjects[] object;
    private boolean hasLit ;
    private boolean Lit ;

    public Room(boolean hasLit){
        object = new RoomObjects[4] ;
        this.hasLit = hasLit ;
        this.Lit = false;
    }

    public void setEast(RoomObjects EastObject){
        object[0] = EastObject ;
        object[0].setDirections(Directions.EAST);
    }
    public void setNorth(RoomObjects NorthObject){
        object[1] = NorthObject ;
        object[1].setDirections(Directions.NORTH);
    }
    public void setWest(RoomObjects WestObject) {
        object[2] = WestObject ;
        object[2].setDirections(Directions.WEST);
    }
    public void setSouth(RoomObjects SouthObject){
        object[3] = SouthObject ;
        object[3].setDirections(Directions.SOUTH);
    }

    public RoomObjects getEastObj(){
        return object[0] ;
    }
    public RoomObjects getNorthObj(){
        return object[1] ;
    }
    public RoomObjects getWestObj(){
        return object[2] ;
    }
    public RoomObjects getSouthObj(){
        return object[3] ;
    }

    public boolean checkLit(){
        return hasLit ;
    }

    public boolean isLit(){
        return Lit ;
    }
    public void toggleLit(){
        Lit = !Lit;
    }

    @Override
    public String toString() {
        return "Room";
    }
}
