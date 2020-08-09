package com.javatechie.spring.ajax.api.model.maze;



import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.commands.AvailableCommand;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Flashlight;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.items.Keys;
import com.javatechie.spring.ajax.api.model.objects.items.MazePoints;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MazeGame {

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
        Keys key1 = new MazeBuilder().AddKey("YellowKey" , 10) ;
        Keys key2 = new MazeBuilder().AddKey("RedKey" , 20);
        Keys key3 = new MazeBuilder().AddKey("BlueKey" , 30) ;
        Keys key4 = new MazeBuilder().AddKey("GreenKey" , 40);
        Keys key5 = new MazeBuilder().AddKey("OrangeKey" , 50);

        // Room1 Objects

        Mirror mirrorR1 = new MazeBuilder().AddMirror() ;
        mirrorR1.setKey(key2);

        Paint paintR1 = new MazeBuilder().AddPaint();
        paintR1.setKey(key1);

        Flashlight flashlightR1 = new Flashlight() ;
        flashlightR1.SetPrice(30);
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

    public String startStatement(){
        return "Game Started, you have 120 minutes to compete and run away, you can run through the winning doors\n" ;
    }
    public String playerWon(){
        return " has escaped the maze\n";
    }
    public String playerLost(){
        return " has escaped the maze\n";
    }

    public String endtStatement(){
        return "Game over\n" ;
    }
    public void setPlayers(GameMap gameMap , ArrayList<Player>players){
        for (int i =0 ; i<players.size() ; ++i){
            players.get(i).setRoomID((int)(Math.random()*7));
        }
    }


    /*public static HashMap<String , Boolean> CheckAvailableCommands(Room CurrRoom, RoomObjects Obj , Player player){
        AvailableCommand avbCmd = new AvailableCommand(CurrRoom , Obj , player) ;
        return avbCmd.getAvbCmd() ;
    }


    public static void ProcessCommands(String command , GameMap mazeMap) {
        ProcessCommand processCommand= new ProcessCommand(command , mazeMap) ;
        processCommand.ProcessCmd() ;

    }
    public static void startGame (String [] args) {

        Executors.newSingleThreadScheduledExecutor().schedule(() -> System.exit(0), 1800, TimeUnit.SECONDS);

       // Player player = new Player("Amal") ;
        GameMap mazeMap = newMap() ;
        //player.setRoomID(/*(int)(Math.random()*7) 0);
        System.out.println("Welcome to the Maze Game, You are now at Room 1");
        System.out.println("You have 30 minutes to get outside the maze,"
                + " otherwise the maze will crash and you lose");

        /*Scanner sc = new Scanner(System.in);

            while (true) {
                int CurrRoomID = player.getCurrRoomID() ;
                if (CurrRoomID == 7)
                {
                    System.out.println("You Won");
                    break ;
                }
                // Directions PlayerDir = player.PlayerDirection();
                Room CurrRoom = mazeMap.getRoom(CurrRoomID) ;
                // RoomObjects Obj  = getObjDir(CurrRoom , PlayerDir);
                RoomObjects Obj = player.getObjDir(CurrRoom) ;
                HashMap<String , Boolean> AvbCommands = CheckAvailableCommands(CurrRoom, Obj , player);
                System.out.println("You Have The following Commands:");
                for(Map.Entry<String, Boolean> mp : AvbCommands.entrySet()){
                    System.out.println(mp.getKey());
                }
                String command = sc.nextLine() ;
               /* while (AvbCommands.get(command) == null){
                    System.out.println("Not Available Command");
                    command = sc.nextLine() ;
                }
                if (command.equals("Quit")){
                    System.out.println("Game Over");
                    System.exit(0);
                }
                if (command.equals("Restart")){
                    break;
                }
                Invoker invoker = new Invoker();
                System.out.println(invoker.takeCommand(command , player , mazeMap));
                //ProcessCommands(command , mazeMap);
            }
        }*/

}