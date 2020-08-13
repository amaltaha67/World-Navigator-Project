package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.directors.Directions;
import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;

public class Look implements Command {
    private Room room ;
    private Player player ;
    public Look(GameMap mazeMap , Player player , String itemName){
        this.player = player ;
        room = mazeMap.getRoom(player.getCurrRoomID());


    }

    @Override
    public String execute() {
        if (!room.isLit()){
            return "Dark Room\n";
        }

        if (player.PlayerDirection().getDirection() == Directions.WEST) {
            room.getWestObj().setLooked();
            return room.getWestObj().toString();
        }
        else if (player.PlayerDirection().getDirection() == Directions.NORTH) {
            room.getNorthObj().setLooked();
            return  room.getNorthObj().toString();
        }else if (player.PlayerDirection().getDirection() == Directions.EAST) {
            room.getEastObj().setLooked();
           return room.getEastObj().toString();
        }else {
            room.getSouthObj().setLooked();
            return room.getSouthObj().toString();
        }
    }
}