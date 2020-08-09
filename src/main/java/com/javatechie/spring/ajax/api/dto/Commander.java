package com.javatechie.spring.ajax.api.dto;

import java.util.List;

public class Commander {
    int mazePlayer ;
    String mazeCommand ;

    public Commander(int mazePlayer, String mazeCommand) {
        this.mazePlayer = mazePlayer;
        this.mazeCommand = mazeCommand;
    }

    public void setMazePlayer(int mazePlayer) {
        this.mazePlayer = mazePlayer;
    }

    public void setMazeCommand(String mazeCommand) {
        this.mazeCommand = mazeCommand;
    }

    public Player getMazePlayer(List<Player> players) {
        for (Player player : players) {
            if (player.getPlayerIDS() == mazePlayer)
                return player;
        }
        return null;
    }

    public String getMazeCommand() {

        return mazeCommand;
    }


}
