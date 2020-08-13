package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.Seller;

public class Buy implements Command {


    private Player player ;
    private Seller seller ;
    private Items SellerItem;
    private String itemName ;

    public Buy(GameMap mazeMap , Player player , String itemName){
        this.player = player ;
        Room CurrRoom =   mazeMap.getRoom(player.getCurrRoomID());
        RoomObjects roomObject = player.getObjDir(CurrRoom) ;
        seller = ((Seller) roomObject);
        this.itemName = itemName;
        SellerItem = seller.checkItem(itemName) ;
    }


    @Override
    public String execute() {
        if (SellerItem == null){
            return "The Seller doesn't have the" + itemName + "\n";
        }

        if(player.PlayerMazePoints() - SellerItem.getPrice() > 0) {
            player.addSellerItem(SellerItem);
            seller.RemoveItem(SellerItem);
            return "Buying" + itemName + "\n" ;
        }else{
            return "Not enough maze points\n";
        }
    }

    @Override
    public String toString() {
        return "Buying item" ;
    }
}