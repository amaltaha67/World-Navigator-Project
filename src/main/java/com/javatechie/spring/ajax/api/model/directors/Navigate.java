package com.javatechie.spring.ajax.api.model.directors;


import com.javatechie.spring.ajax.api.dto.Player;

public class Navigate{
    private Director Direction;
    private Player player;
    public Navigate(Player player){
        Direction = new Director() ;
        this.player = player ;
    }
    public String goLeft(){
        Direction = player.PlayerDirection();
        Direction.turnLeft();
        player.ChangeDirection(Direction);
        return "Moving " + player.getPlayerIDS() + " to the left\n";
    }

    public String goRight(){
        Direction = player.PlayerDirection();
        Direction.turnRight();
        player.ChangeDirection(Direction);
        return "Moving " + player.getPlayerIDS() + " to the right\n";
    }

    public String getPlayerStatus(){
       // getPlayerMazePoints();
        String playerItems= "";
        for(int i =0 ; i<player.PlayerItems().size() ; ++i){
            playerItems+=player.PlayerItems().get(i) ;
        }
        return getPlayerDirection() + "\n" + getPlayerMazePoints() + "\n" + playerItems ; //player.PlayerItems();
      /*  System.out.println(getPlayerDirection());
        System.out.println(getPlayerMazePoints());
        player.PlayerItems();*/
    }
    public int getPlayerMazePoints(){
        return player.PlayerMazePoints() ;
    }
    public Directions getPlayerDirection(){
        return player.PlayerDirection().getDirection();
    }

    @Override
    public String toString() {
        return "Navigating through rooms";
    }
}
