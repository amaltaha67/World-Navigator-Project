package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.directors.Navigate;
import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;

public class GetPlayerStatus implements Command{
    private Navigate nav ;

    public GetPlayerStatus(GameMap mazeMap , Player player , String itemName){
        nav = new Navigate(player);
    }

    @Override
    public String execute() {
      return  nav.getPlayerStatus();
    }
}