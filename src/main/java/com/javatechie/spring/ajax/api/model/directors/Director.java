package com.javatechie.spring.ajax.api.model.directors;

public class Director {
    private Directions CurrDirection = Directions.EAST;

    public void setDirection(Directions dir){
        CurrDirection = dir;
    }
    public Directions getDirection(){
        return CurrDirection ;
    }
    public void turnLeft(){
        if (CurrDirection == Directions.EAST)
            CurrDirection =  Directions.NORTH;
        else if (CurrDirection == Directions.NORTH)
            CurrDirection =  Directions.WEST;
        else if (CurrDirection == Directions.WEST)
            CurrDirection =  Directions.SOUTH;
        else if (CurrDirection == Directions.SOUTH)
            CurrDirection =  Directions.EAST;
    }

    public void turnRight(){
        if (CurrDirection == Directions.EAST)
            CurrDirection =  Directions.SOUTH;
        else if (CurrDirection == Directions.NORTH)
            CurrDirection =  Directions.EAST;
        else if (CurrDirection == Directions.WEST)
            CurrDirection =  Directions.NORTH;
        else if (CurrDirection == Directions.SOUTH)
            CurrDirection =  Directions.WEST;
    }
}
