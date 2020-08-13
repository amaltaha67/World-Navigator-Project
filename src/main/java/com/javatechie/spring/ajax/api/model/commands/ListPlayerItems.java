package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.items.Items;

import java.util.ArrayList;

public class ListPlayerItems implements Command {
    private Player player ;
    public ListPlayerItems(GameMap mazeMap , Player player , String itemName){
        this.player = player ;
    }

    @Override
    public String execute() {

        ArrayList<Items> playerItems =  player.PlayerItems();
        String s = "";
        for (Items playerItem : playerItems) {
            s += playerItem.toString();
        }
        return s ;
    }
}

