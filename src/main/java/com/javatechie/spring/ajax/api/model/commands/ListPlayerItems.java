package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.model.maze.Player;

public class ListPlayerItems implements Command {
    private Player player ;
    public ListPlayerItems(GameMap mazeMap , Player player , String itemName){
        this.player = player ;
    }

    @Override
    public String execute() {

        return  player.PlayerItems().toString();
    }
}

