package com.javatechie.spring.ajax.api.model.maze;


import com.javatechie.spring.ajax.api.model.objects.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameMap {
    private Graph g;
    private HashMap<Room, Integer> Rooms;
    private HashMap<Integer, Room> RoomsID;
    private List<Room> Adj;

    public GameMap(ArrayList<Room> MazeRooms){
        Rooms = new HashMap<>();
        RoomsID = new HashMap<>();
        for (int i =0 ; i<MazeRooms.size() ; ++i) {
            Rooms.put(MazeRooms.get(i) , i) ;
            RoomsID.put(i , MazeRooms.get(i)) ;
        }

        g = new Graph(MazeRooms.size()) ;

        Adj = new ArrayList<>();
    }

    public void addDoor(Room v, Room w){
        if (v == null || w==null)
            throw new IllegalArgumentException();
        g.addEdge(Rooms.get(v) , Rooms.get(w)) ;
    }
    public Room getRoom(int ID) {
        return RoomsID.get(ID) ;
    }
    public int getRoomID(Room Room) {
        return Rooms.get(Room) ;
    }

    public Iterable<Room> adj(Room v) {
        if (Rooms.get(v) == null)
            throw new IllegalArgumentException();

        for (int i:g.adj(Rooms.get(v))) {

            Adj.add(RoomsID.get(i)) ;
        }
        return Adj;
    }


}