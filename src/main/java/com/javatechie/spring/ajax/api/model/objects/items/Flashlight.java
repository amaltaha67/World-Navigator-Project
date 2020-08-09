package com.javatechie.spring.ajax.api.model.objects.items;

import com.javatechie.spring.ajax.api.model.objects.Room;

public class Flashlight implements Items {
    private int price = 0 ;

    @Override
    public void SetPrice( int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return "Flashlight";
    }

    @Override
    public int getPrice(){
        return  price ;
    }


    public String UseFlashlight(Room room) {
        if (room.isLit()) {
            //   System.out.println("The light in turned on in this room");
            return "The light in turned on in this room\n";
        }else{
            room.toggleLit();
            return "The light is already turned on in this room\n";
        }
    }

    @Override
    public String toString() {
        return "New flashlight";
    }
}
