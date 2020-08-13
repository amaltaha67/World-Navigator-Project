package com.javatechie.spring.ajax.api.model.maze;



import com.javatechie.spring.ajax.api.dto.Commander;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.commands.AvailableCommand;
import com.javatechie.spring.ajax.api.model.commands.Invoker;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Flashlight;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.items.Keys;
import com.javatechie.spring.ajax.api.model.objects.items.MazePoints;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MazeGame {
    ArrayList<Player> players = new ArrayList<>();
    boolean joinPlayer = true ;
    HashMap<Integer, Boolean> reservedRoom = new HashMap<>();
    HashMap<Integer, Boolean>reservedIDs= new HashMap<>();
    public  GameMap newMap(){

        ArrayList<Room>MazeRooms = new ArrayList<>() ;

        MazeRooms.add(new Room(true)) ;
        MazeRooms.add(new Room(true)) ;
        MazeRooms.add(new Room(false)) ;
        MazeRooms.add(new Room(true)) ;
        MazeRooms.add(new Room(false)) ;
        MazeRooms.add(new Room(true)) ;
        MazeRooms.add(new Room(true)) ;
        MazeRooms.add(new Room(true)) ;

        GameMap mazeGraph = new GameMap(MazeRooms) ;

        mazeGraph.addDoor(MazeRooms.get(0) , MazeRooms.get(1));
        mazeGraph.addDoor(MazeRooms.get(1) , MazeRooms.get(2));
        mazeGraph.addDoor(MazeRooms.get(1) , MazeRooms.get(3));
        mazeGraph.addDoor(MazeRooms.get(2) , MazeRooms.get(5));
        mazeGraph.addDoor(MazeRooms.get(3) , MazeRooms.get(4));
        mazeGraph.addDoor(MazeRooms.get(4) , MazeRooms.get(6));
        mazeGraph.addDoor(MazeRooms.get(6) , MazeRooms.get(7));

        // setting keys values and names
        Keys key1 = new MazeBuilder().AddKey("YellowKey") ;
        Keys key2 = new MazeBuilder().AddKey("RedKey" );
        Keys key3 = new MazeBuilder().AddKey("BlueKey" ) ;
        Keys key4 = new MazeBuilder().AddKey("GreenKey" );
        Keys key5 = new MazeBuilder().AddKey("OrangeKey" );

        // Room1 Objects

        Mirror mirrorR1 = new MazeBuilder().AddMirror() ;
        mirrorR1.setKey(key2);

        Paint paintR1 = new MazeBuilder().AddPaint();
        paintR1.setKey(key1);

        Flashlight flashlightR1 = new Flashlight() ;
        HashMap<Items, Integer> SellerItems = new HashMap<>() ;
        SellerItems.put(flashlightR1 , flashlightR1.getPrice()) ;
        Seller sellerR1 = new MazeBuilder().AddSeller(SellerItems) ;


        Door DoorR1R2  = new MazeBuilder().AddDoor(true) ;
        DoorR1R2.setKey(key1);

        MazeRooms.get(0).setWest(paintR1);
        MazeRooms.get(0).setNorth(mirrorR1);
        MazeRooms.get(0).setSouth(sellerR1);
        MazeRooms.get(0).setEast(DoorR1R2);

        //Room2 Objects
        MazePoints mazePointsChestR2 = new MazePoints() ;
        mazePointsChestR2.SetPrice(15);

        Chest chestR2 = new MazeBuilder().AddChest(true) ;
        chestR2.setKey(key2);
        chestR2.AddItem(mazePointsChestR2);

        Door DoorR2R3  = new MazeBuilder().AddDoor(false) ;

        Door DoorR2R4  = new MazeBuilder().AddDoor(true) ;
        DoorR2R4.setKey(key5);

        MazeRooms.get(1).setWest(DoorR1R2);
        MazeRooms.get(1).setNorth(chestR2);
        MazeRooms.get(1).setSouth(DoorR2R3);
        MazeRooms.get(1).setEast(DoorR2R4);

        // Room3 Objects
        Door DoorR3R6 = new MazeBuilder().AddDoor(false);
        Chest chestR3 = new MazeBuilder().AddChest(false) ;
        MazePoints pointsChestR3 = new MazePoints() ;
        pointsChestR3.SetPrice(50);
        chestR3.AddItem(pointsChestR3);
        SellerItems.clear();
        SellerItems.put(key5 , key5.getPrice());
        Seller sellerR3 = new MazeBuilder().AddSeller(SellerItems) ;

        MazeRooms.get(2).setWest(chestR3);
        MazeRooms.get(2).setNorth(DoorR2R3);
        MazeRooms.get(2).setSouth(sellerR3);
        MazeRooms.get(2).setEast(DoorR3R6);

        //Room6 Objects
        MazeRooms.get(5).setWest(DoorR3R6);
        MazeRooms.get(5).setNorth(new MazeBuilder().AddMirror());
        MazeRooms.get(5).setSouth(new MazeBuilder().AddPlainWall());
        MazeRooms.get(5).setEast(new MazeBuilder().AddPlainWall());

        //Room4 Objects
        Paint paintR4 = new MazeBuilder().AddPaint() ;
        paintR4.setKey(key3);
        Door DoorR4R5 = new MazeBuilder().AddDoor(false) ;

        MazeRooms.get(3).setWest(DoorR2R4);
        MazeRooms.get(3).setNorth(new MazeBuilder().AddMirror());
        MazeRooms.get(3).setSouth(paintR4);
        MazeRooms.get(3).setEast(DoorR4R5);

        // Room5 Objects
        SellerItems.clear();
        SellerItems.put(key4 , key4.getPrice()) ;
        Seller sellerR5 = new MazeBuilder().AddSeller(SellerItems) ;

        Chest chestR5 = new MazeBuilder().AddChest(true) ;
        chestR5.setKey(key3);
        MazePoints PointsChestR5 = new MazePoints();
        PointsChestR5.SetPrice(10);
        chestR5.AddItem(PointsChestR5);
        Door DoorR5R7 = new MazeBuilder().AddDoor(true) ;
        DoorR5R7.setKey(key4);

        MazeRooms.get(4).setWest(DoorR4R5);
        MazeRooms.get(4).setNorth(sellerR5);
        MazeRooms.get(4).setSouth(DoorR5R7);
        MazeRooms.get(4).setEast(chestR5);

        //Room7 Objects
        SellerItems.clear();
        Door FinalDoor = new MazeBuilder().AddDoor(false) ;
        MazeRooms.get(6).setWest(new MazeBuilder().AddSeller(SellerItems));
        MazeRooms.get(6).setNorth(DoorR5R7);
        MazeRooms.get(6).setSouth(new MazeBuilder().AddMirror());
        MazeRooms.get(6).setEast(FinalDoor);

        // Exit Room
        MazeRooms.get(7).setWest(FinalDoor);
        return mazeGraph ;

    }


    public String addPlayer(Player player){
        if (!joinState() || reservedIDs.get(player.getPlayerIDS()) != null)
            return "Can't add player\n"  ;
        reservedIDs.put(player.getPlayerIDS() , true) ;
        players.add(player) ;
        return player.getPlayerIDS() + " " + player.getPlayerNameF() + "\n" ;
    }
    public ArrayList<Player> getPlayers(){
        return players ;
    }

    public  String removePlayer(Player player){
        if (reservedIDs.get(player.getPlayerIDS()) == null)
            return "Player Does not exist" ;
        reservedIDs.remove(player.getPlayerIDS()) ;
        players.remove(player) ;
        return player.getPlayerIDS() + " gave up and left the game\n" ;
    }
    public String startStatement(){
        return "Game Started, you have 120 minutes to compete and run away, you can run through the winning doors\n" ;
    }
    public String playerWon(){
        return " has escaped the maze\n";
    }

    public void setPlayers(ArrayList<Player>players){
        for (Player player : players) {
            player.setRoomID((int) (Math.random() * 6));
        }
    }
    public void joinPlayer(boolean gameState){
        joinPlayer = gameState ;
    }
    public boolean joinState(){
        return joinPlayer;
    }

    public static HashMap<String , Boolean> CheckAvailableCommands(Room CurrRoom, RoomObjects Obj , Player player){
        AvailableCommand avbCmd = new AvailableCommand(CurrRoom , Obj , player) ;
        return avbCmd.getAvbCmd() ;
    }


    public void stealItems(Player firstPlayer , Player secondPlayer){
        for (int i = 0 ; i<secondPlayer.PlayerItems().size() ; ++i){
            firstPlayer.addItem(secondPlayer.PlayerItems().get(i));
        }
    }
    public String checkForFights(){
        ArrayList<Player> eliminate = new ArrayList<>();
        for (int i = 0 ; i<players.size() ; ++i) {
            for (int j = i+1 ; j<players.size() ; ++j) {
                if (players.get(i).getCurrRoomID() == players.get(j).getCurrRoomID()){
                    if (players.get(i).PlayerMazePoints() - players.get(j).PlayerMazePoints() > 0){
                        stealItems(players.get(i) , players.get(j)) ;
                        eliminate.add(players.get(j)) ;
                    }else {
                        stealItems(players.get(j) , players.get(i)) ;
                        eliminate.add(players.get(i)) ;

                    }

                }
            }
        }
        String elm  = "" ;
        if (eliminate.size() != 0)
            elm += "eliminating " ;
        for (int i = 0 ; i<eliminate.size() ; ++i){
            elm+= eliminate.get(i).getPlayerIDS() ;
            reservedIDs.remove(eliminate.get(i).getPlayerIDS());
            players.remove(i);
        }

        eliminate.clear();
        return elm+"\n" ;
    }
    public String checkForWinner(){
        for (Player player : players) {
            if (player.getCurrRoomID() == 7)
                return player.getPlayerIDS() + playerWon();
        }
        return "";
    }


    public String processCommand(Commander commander , GameMap gameMap){
        String mazeCommand = commander.getMazeCommand();
        Player player = commander.getMazePlayer(players);
        if (mazeCommand.equals("GiveUp"))
            return removePlayer(player) ;

        if (reservedIDs.get(player.getPlayerIDS()) == null)
            return "Player does not exist\n" ;

        Invoker invoker = new Invoker();
        String res = invoker.takeCommand(mazeCommand , player , gameMap) ;
        res+= checkForFights();
        res+= checkForWinner();
        return res;
    }


}