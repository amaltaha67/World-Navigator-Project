package com.javatechie.spring.ajax.api.model.objects.roomobjects;

import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.items.Keys;

import java.util.ArrayList;

public class Chest extends RoomObjects{
    private ArrayList<Items> ChestItems;
    private Keys key ;
    private Lockable chestLock;
    private boolean needKey ;
    private boolean Check ;
    public Chest (boolean needKey){
        ChestItems = new ArrayList<>() ;
        this.needKey = needKey ;
        if (needKey)
            chestLock = new Lockable(true) ;
        else
            chestLock = new Lockable(false) ;
        Check = false ;
    }

    public void setKey(Keys key){
        if (!checkKey()){
            NeedKey();
            return ;
        }
        this.key = key ;
    }
    public Keys getKey(){return key ;}
    public void AddItem(Items I) {
        ChestItems.add(I) ;
    }

    public boolean checkKey(){
        return needKey ;
    }


    public String open(Player player){
        if (checkChest())
            if (player.checkItem(key.getName()) != null){
                chestLock.UnLock();
                addItemsToPlayer(player);
                return "The Chest is now open\n";
            }else
             return  check(player);
        else
            return "The Chest is open\n";

    }

    @Override
    public String check(Player player){
        Check = true ;
        if (checkChest()) {
            return "This Chest requires " + key.getName() + "\n";
        } else {
            return "The Chest is open\n";
        }
    }
    public void addItemsToPlayer(Player player) {
        for (Items chestItem : ChestItems) {
            player.addItem(chestItem);
        }
    }
    public boolean isChecked(){return Check; }
    public boolean checkChest(){
        return chestLock.LockStatus();
    }

    public  String NeedKey(){
        if (!checkKey())
             return "No need for key for this chest";
        else
            return "This chest requires" + key.getName() + "\n";
    }


    public ArrayList<Items> listItems() {
        ArrayList<Items> tmp = new ArrayList<>(ChestItems);
        return tmp ;
    }

    @Override
    public String toString() {
        return "Chest";
    }
}
