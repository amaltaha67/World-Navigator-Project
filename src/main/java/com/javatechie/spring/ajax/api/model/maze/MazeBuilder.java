package com.javatechie.spring.ajax.api.model.maze;

import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.items.Keys;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.*;

import java.util.HashMap;

public class MazeBuilder implements Builder {

    @Override
    public Mirror AddMirror() {
        return new Mirror() ;
    }

    @Override
    public Keys AddKey(String keyName ) {
        Keys newKey = new Keys(keyName) ;
        return newKey ;

    }

    @Override
    public Door AddDoor(boolean isLocked) {
        return new Door(isLocked) ;
    }

    @Override
    public Seller AddSeller(HashMap<Items, Integer> SellerItems) {
        Seller seller = new Seller() ;
        for (HashMap.Entry<Items, Integer> it : SellerItems.entrySet()){
            seller.AddItem(it.getKey()) ;
        }
        return seller ;
    }

    @Override
    public PlainWall AddPlainWall() {
        return new PlainWall() ;
    }


    @Override
    public Paint AddPaint() {
        return new Paint();
    }

    @Override
    public Chest AddChest(boolean needKey) {
        return new Chest(needKey) ;
    }

    @Override
    public String toString() {
        return "Maze Builder";
    }
}