package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Keys;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;

public class UseKey implements Command{
    private Room room ;
    private Keys key ;
    private Player player;
    private RoomObjects Obj;

    public UseKey(GameMap mazeMap , Player player , String itemName) {
        this.player = player ;
        room = mazeMap.getRoom(player.getCurrRoomID()) ;
        Obj = player.getObjDir(room) ;
        key = new Keys(itemName) ;

    }

    @Override
    public String execute() {

        if (!Obj.toString().equals("Chest") && !Obj.toString().equals("Door"))
            return "Can't use This key on " + Obj + "\n";
        return key.useKey(player , Obj);
    }

    @Override
    public String toString() {
        return "Using the" + key.getName();
    }
}
