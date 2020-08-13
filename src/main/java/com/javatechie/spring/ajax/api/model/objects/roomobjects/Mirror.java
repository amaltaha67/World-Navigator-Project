package com.javatechie.spring.ajax.api.model.objects.roomobjects;


import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.items.Keys;

public class Mirror extends RoomObjects{
    private Keys key ;

    public void setKey(Keys key){
        this.key = key ;
    }
    public boolean checkKey(){
        return key != null ;
    }
    public Keys getKey() {
        if (checkKey())
            return key ;
        return null ;
    }

    @Override
    public String check(Player player){
        if (getKey() != null){
            player.addItem(key);
            return "Key " + key.getName() + " Was acquired\n";
        }else {
            return "No key on this Mirror\n";
        }
    }

    @Override
    public String toString() {
        return "Mirror";
    }
}
