package com.javatechie.spring.ajax.api.model.objects.items;

public class MazePoints implements Items{
    private int value = 0 ;

    public void SetPrice(int price) {
        value = price ;
    }

    @Override
    public String getName() {
        return "Maze Points";
    }

    @Override
    public int getPrice() {
        return value;
    }

    @Override
    public String toString() {
        return "Maze Points";
    }
}
