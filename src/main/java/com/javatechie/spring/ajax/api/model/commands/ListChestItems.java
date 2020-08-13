package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.Chest;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;


import java.util.ArrayList;

public class ListChestItems implements Command {
    private Chest chest ;
    public ListChestItems(GameMap mazeMap , Player player , String itemName){
        Room CurrRoom =   mazeMap.getRoom(player.getCurrRoomID());
        RoomObjects roomObject = player.getObjDir(CurrRoom) ;
        chest = ((Chest) roomObject);

    }

    @Override
    public String execute() {

        ArrayList<Items> chestItems =  chest.listItems();
        String s = "";
        for (Items sellerItem : chestItems) {
            s += sellerItem.toString();
        }
        return s ;
    }
}
