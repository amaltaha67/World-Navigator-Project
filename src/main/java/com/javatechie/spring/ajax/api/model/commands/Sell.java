package com.javatechie.spring.ajax.api.model.commands;

import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.Seller;

public class Sell implements Command {

    private Player player ;
    private Seller seller ;
    private Items PlayerItem;
    private String itemName ;
    public Sell(GameMap mazeMap , Player player , String itemName){
        this.player = player ;
        Room CurrRoom =   mazeMap.getRoom(player.getCurrRoomID());
        RoomObjects roomObject = player.getObjDir(CurrRoom) ;
        seller = ((Seller) roomObject);
        this.itemName = itemName;
        PlayerItem = player.checkItem(itemName) ;

    }


    @Override
    public String execute() {
        if (PlayerItem == null){
            return "The Player doesn't have the " + itemName + "\n";
        }

        player.sellItem(PlayerItem);
        seller.AddItem(PlayerItem);
        return "The player sold " + itemName + "\n";
    }

    @Override
    public String toString() {
        return "Selling item";
    }
}
