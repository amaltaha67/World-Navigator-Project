package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.model.maze.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;

public class SwitchLight implements Command{
    private Room CurrRoom ;

    public SwitchLight(GameMap mazeMap , Player player , String itemName){
        CurrRoom =   mazeMap.getRoom(player.getCurrRoomID());
    }

    @Override
    public String execute() {
          CurrRoom.toggleLit();
          return "The light is toggled in this room\n" ;
    }
}
