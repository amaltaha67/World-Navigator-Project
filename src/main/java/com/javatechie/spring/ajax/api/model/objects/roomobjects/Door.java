package com.javatechie.spring.ajax.api.model.objects.roomobjects;


import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.items.Keys;

public class Door extends RoomObjects{
    private Lockable DoorLock;
    private Keys key ;
    private boolean Check ;
    public Door(boolean isLocked){

        DoorLock = new Lockable(isLocked) ;
        Check = false ;
    }
    public boolean isChecked(){return Check ; }
    public String setKey(Keys key){
        if (checkDoor()) {
            this.key = key;
            return "The key was set\n";
        }else
            return "No need for a key for this door\n";
    }
    public Keys getKey(){
        return key ;
    }

    @Override
    public String open(Player player){
        if (checkDoor()) {
            if (player.checkItem(key.getName()) != null) {
                DoorLock.UnLock();
                return "The Door is now open\n";
            } else
                return check(player);
        }else
            return "The Door is open\n" ;
    }

    @Override
    public String check(Player player){
        Check = true ;
        if (checkDoor()) {
            return "This Door requires " + key.getName() + "\n";
        }else {
            return "The Door is open\n";
        }
    }
    public boolean checkDoor(){
        return DoorLock.LockStatus();
    }

    @Override
    public String toString() {
        return "Door" ;
    }

}
