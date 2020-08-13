package com.javatechie.spring.ajax.api.model.objects.items;


import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;

public class Keys implements Items {
    private String Name;
    private int price ;

    public Keys(String Name){
        this.Name = Name ;
        price = 20;
    }

    public void setName(String name){
        Name = name;
    }

    @Override
    public String getName(){
        return Name ;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public String useKey(Player player, RoomObjects Obj){
        Obj.open(player);
        return "Key is used on " + Obj + "\n" ;
    }

    @Override
    public String toString() {
        return "new Key" + getName();
    }
}
