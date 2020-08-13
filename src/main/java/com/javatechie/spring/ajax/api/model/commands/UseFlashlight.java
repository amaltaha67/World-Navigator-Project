package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Flashlight;
import com.javatechie.spring.ajax.api.model.objects.items.Items;

public class UseFlashlight implements Command{
    private Room room ;
    private Flashlight flashlight ;
    private Player player;
    public UseFlashlight(GameMap mazeMap , Player player , String itemName) {
        this.player = player ;
        room = mazeMap.getRoom(player.getCurrRoomID()) ;
        flashlight = new Flashlight() ;
    }
    @Override
    public String execute() {
        Items item = player.checkItem("Flashlight");
        if (item != null)
             return  flashlight.UseFlashlight(room);
        else
            return "The player don't have a Flashlight\n";
    }

    @Override
    public String toString() {
        return "Using flashlight";
    }
}
