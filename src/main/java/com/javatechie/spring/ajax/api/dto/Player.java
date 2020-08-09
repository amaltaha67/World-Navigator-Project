package com.javatechie.spring.ajax.api.dto;

import java.util.ArrayList;
import java.util.HashMap;

import com.javatechie.spring.ajax.api.model.directors.Directions;
import com.javatechie.spring.ajax.api.model.directors.Director;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;

public class Player {

    private int playerIDS ; // needs to be deleted
    private String playerNameF ;
    private String playerNameS;

    private HashMap<Items, Integer> ownedItems ;
    private int MazePoints;
    private Director Direction ;
    private int currRoomID ;

    public Player(int playerIDS , String playerNameF , String playerNameS){
        ownedItems = new HashMap<>() ;
        MazePoints = 100 ;
        Direction = new Director();
        this.playerIDS = playerIDS ;
        this.playerNameF = playerNameF ;
        this.playerNameS = playerNameS ;
    }

    public void setPlayerNameS(String playerNameS) {
        this.playerNameS = playerNameS;
    }

    public String getPlayerNameS() {
        return playerNameS;
    }
    public void setPlayerID(int playerIDS) {
        this.playerIDS = playerIDS;
    }

    public void setPlayerName(String playerNameF) {
        this.playerNameF = playerNameF;
    }

    public int getPlayerIDS(){
        return playerIDS ;
    }

    public String getPlayerNameF() {
        return playerNameF;
    }

    public void ChangeDirection(Director dir){
        Direction = dir ;
    }
    public void addItem(Items item){
        MazePoints+=item.getPrice();
        ownedItems.put(item , item.getPrice()) ;
    }
    public void addSellerItem(Items item){
        ownedItems.put(item , item.getPrice()) ;
        MazePoints-=item.getPrice() ;
    }
    public void sellItem(Items item) {
        ownedItems.remove(item , item.getPrice()) ;
        MazePoints+=item.getPrice() ;
    }
    public int PlayerMazePoints(){
        return  MazePoints ;
    }
    public Director PlayerDirection(){
        return Direction ;
    }

    public RoomObjects getObjDir(Room room){
        if (PlayerDirection().getDirection() == Directions.EAST)
            return room.getEastObj();
        else if (PlayerDirection().getDirection() == Directions.WEST)
            return room.getWestObj();
        else if (PlayerDirection().getDirection() == Directions.NORTH)
            return room.getNorthObj();
        else
            return room.getSouthObj();
    }
    public ArrayList<Items> PlayerItems() {
        ArrayList<Items>tmp = new ArrayList<>() ;
        ownedItems.forEach((key, value) -> tmp.add(key));
        return tmp ;
    }
    public  Items checkItem( String ItemName){
        Items item = null ;
        ArrayList<Items> PlayerItems = PlayerItems();
        for (Items plyrItms : PlayerItems) {
            if (plyrItms.getName().equals(ItemName)) {
                item = plyrItms;
                break;
            }
        }
        return item ;
    }
    public void setRoomID(int ID){
        currRoomID = ID  ;
    }
    public int getCurrRoomID (){
        return currRoomID ;
    }
/*
    @Override
    public String toString() {
        return "Player{" +
                "playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                '}';
    }*/
}
