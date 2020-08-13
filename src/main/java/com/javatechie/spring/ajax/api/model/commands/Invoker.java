package com.javatechie.spring.ajax.api.model.commands;



import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;

import java.lang.reflect.Constructor;

public class Invoker {
    private String command ="" ;
    private String item = "" ;

    public String takeCommand(String Cmd , Player player , GameMap mazeMap) {

        boolean split = false ;
        for (int i = 0 ; i<Cmd.length() ; ++i){

            char c = Cmd.charAt(i) ;
            if (c == ' '){
                split = true ;
                continue;
            }
            if (!split)
                command+=c ;
            else
                item+=c;
        }
        Constructor<?>constructor ;
        Command cmd = null ;
        try{
            Class<?> c = Class.forName("com.javatechie.spring.ajax.api.model.commands." + command) ;
            constructor = c.getDeclaredConstructor(GameMap.class , Player.class , String.class);
            cmd = (Command) constructor.newInstance(mazeMap , player , item);
        }catch(Exception e){
            return "Not available command\n";
        }
        return cmd.execute();



    }
}
