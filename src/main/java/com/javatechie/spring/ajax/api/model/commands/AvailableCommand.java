package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.Chest;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.Door;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.Seller;

import java.util.ArrayList;
import java.util.HashMap;

public class AvailableCommand {
    private Room CurrRoom ;
    private RoomObjects Obj;
    private HashMap<String , Boolean> AvbCommand ;
    private Player player;
    public AvailableCommand(Room room , RoomObjects obj , Player plyr) {
        CurrRoom = room ;
        Obj = obj;
        player = plyr ;
        AvbCommand = new HashMap<String, Boolean>();
    }
    public HashMap<String, Boolean>getAvbCmd(){

        AvbCommand.put("Get Player Status" , true) ;
        AvbCommand.put("Quit" , true) ;
        AvbCommand.put("Restart" , true) ;
        if (!CurrRoom.isLit()){
            if (!CurrRoom.checkLit()) {
                AvbCommand.put("Use Flashlight", true);
            } else
                AvbCommand.put("Switch Lights" , true) ;
            return AvbCommand ;
        }

        AvbCommand.put("Turn Left", true) ;
        AvbCommand.put("Turn Right" , true) ;
        AvbCommand.put("Look" , true) ;

        if (!Obj.Looked(player))
            return AvbCommand ;

        if (Obj.toString().equals("Plain Wall"))
            return AvbCommand ;

        if ("Mirror".equals(Obj.toString())) {
            AvbCommand.put("Check Mirror", true);
        } else if ("Paint".equals(Obj.toString())) {
            AvbCommand.put("Check Paint", true);
        } else if ("Door".equals(Obj.toString())) {
            Door door = ((Door) Obj);
            if (!door.isChecked())
                AvbCommand.put("Check Door", true);
            else if (door.checkDoor())
                AvbCommand.put("Use " + door.getKey().getName(), true);
            else
                AvbCommand.put("Move Forward", true);
        } else if ("Chest".equals(Obj.toString())) {
            Chest chest = ((Chest) Obj);
            if (!chest.isChecked())
                AvbCommand.put("Check Chest", true);
            else if (chest.checkChest() && chest.checkKey())
                AvbCommand.put("Use " + chest.getKey().getName(), true);
            else
                AvbCommand.put("List Chest Items", true);
        } else if ("Seller".equals(Obj.toString())) {
            Seller seller = ((Seller) Obj);
            ArrayList<Items> SellerItems = seller.listItems();
            AvbCommand.put("List Seller Items", true);
            for (Items sellerItem : SellerItems) {
                AvbCommand.put("Buy " + sellerItem.getName(), true);
            }
            for (Items playerItems : player.PlayerItems()) {
                AvbCommand.put("Sell " + playerItems.getName(), true);
            }
        }
        return AvbCommand ;
    }

}