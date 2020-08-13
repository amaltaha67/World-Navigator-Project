package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;

public class Check implements Command {
    private RoomObjects Obj ;
    private Player player ;
    public Check(GameMap mazeMap , Player player , String itemName) {
        this.player = player ;
        Room CurrRoom =   mazeMap.getRoom(player.getCurrRoomID());
        Obj = player.getObjDir(CurrRoom) ;

    }


    @Override
    public String execute() {

        return Obj.check(player);
    }

    @Override
    public String toString() {
        return "Checking object" ;
    }
}