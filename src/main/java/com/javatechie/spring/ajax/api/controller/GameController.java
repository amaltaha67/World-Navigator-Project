package com.javatechie.spring.ajax.api.controller;

import com.javatechie.spring.ajax.api.dto.Commander;
import com.javatechie.spring.ajax.api.dto.ServiceResponse;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.commands.Invoker;
import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.model.maze.MazeGame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {
    ArrayList<Player> players = new ArrayList<>();
    MazeGame mazeGame = new MazeGame();
    GameMap gameMap = mazeGame.newMap();
    boolean joinPlayer = true ;

    @GetMapping("/startGame")
    public ResponseEntity<Object> startGame() {
        joinPlayer = false ;
        String startingStatement = mazeGame.startStatement();
        mazeGame.setPlayers(gameMap , players) ;
        ServiceResponse<String> response = new ServiceResponse<>("success", startingStatement);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }


    @PostMapping("/savePlayer")
    public ResponseEntity<Object> addPlayer(@RequestBody Player player ) {

        if (joinPlayer){
            players.add(player);
            return new ResponseEntity<Object>( new ServiceResponse<Player>
                    ("success", player), HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(new ServiceResponse<String>
                    ("success", "Can't add player"), HttpStatus.OK);
        }

    }

    @GetMapping("/getPlayers")
    public ResponseEntity<Object> getAllPlayers() {
        ServiceResponse<List<Player>> response = new ServiceResponse<>("success", players);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/saveCommand")
    public ResponseEntity<Object> addCommand(@RequestBody Commander commander ) {
        Invoker invoker = new Invoker();
        String res = invoker.takeCommand(commander.getMazeCommand() , commander.getMazePlayer(players) , gameMap) ;
        ServiceResponse<String> response = new ServiceResponse<String>("success", res);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
