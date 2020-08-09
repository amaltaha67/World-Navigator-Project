package com.javatechie.spring.ajax.api.model.objects.roomobjects;


import com.javatechie.spring.ajax.api.model.directors.Directions;
import com.javatechie.spring.ajax.api.model.directors.Director;
import com.javatechie.spring.ajax.api.dto.Player;

public class RoomObjects {
    private Director ObjDirection ;
    private boolean LookedObj ;
    RoomObjects(){
        ObjDirection = new Director();
        LookedObj = false ;
    }
    public void setLooked(){
        LookedObj = true ;
    }

    public void setDirections(Directions dir){
        ObjDirection.setDirection(dir);
    }


    public boolean Looked(Player player){
        return LookedObj ;
    }

    public String check(Player player) {
        return "No available command";
    }
    public String open(Player player) {
        return "No available command";
    }
    @Override
    public String toString() {
        return "Room object";
    }

}
