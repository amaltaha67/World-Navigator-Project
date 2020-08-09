package com.javatechie.spring.ajax.api.model.commands;

import com.javatechie.spring.ajax.api.model.directors.Directions;
import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.Door;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;

public class MoveForward implements Command{
    private GameMap gameMap ;
    private Room CurrRoom ;
    private Door CurrDoor ;
    private Player player  ;

    public MoveForward(GameMap mazeMap , Player player, String itemName) {
        this.gameMap = mazeMap ;
        this.player = player;
        CurrRoom =  mazeMap.getRoom(player.getCurrRoomID());
        CurrDoor = (Door)player.getObjDir(CurrRoom) ;
    }


    public RoomObjects getNewRoomDoor(Room R){
        if (player.PlayerDirection().getDirection() == Directions.EAST)
            return R.getWestObj();
        else if (player.PlayerDirection().getDirection() == Directions.WEST)
            return R.getEastObj();
        else if (player.PlayerDirection().getDirection() == Directions.NORTH)
            return R.getSouthObj();
        else
            return R.getNorthObj();
    }

    @Override
    public String execute() {
        for(Room k: gameMap.adj(CurrRoom)){
            RoomObjects Obj = getNewRoomDoor(k) ;
            if (Obj.toString().equals("Door"))
                if (Obj.equals(CurrDoor))
                    player.setRoomID(gameMap.getRoomID(k));
        }
        return this.toString();
    }

    @Override
    public String toString() {
        return "Moving forward toward next room";
    }
}