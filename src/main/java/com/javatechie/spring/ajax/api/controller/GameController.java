package com.javatechie.spring.ajax.api.controller;

import com.javatechie.spring.ajax.api.dto.Commander;
import com.javatechie.spring.ajax.api.dto.ServiceResponse;
import com.javatechie.spring.ajax.api.model.maze.Player;
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
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class GameController {

    MazeGame mazeGame = new MazeGame();
    GameMap gameMap = mazeGame.newMap();

    //boolean joinPlayer = true ; // needs modification

    @GetMapping("/startGame")
    public ResponseEntity<Object> startGame() {
//        Executors.newSingleThreadScheduledExecutor().schedule(() -> System.out.println("Game Over"), 30, TimeUnit.SECONDS);
        String startingStatement = mazeGame.startStatement();
        mazeGame.setPlayers(gameMap , mazeGame.getPlayers()) ;
        mazeGame.joinPlayer(false);
        ServiceResponse<String> response = new ServiceResponse<>("success", startingStatement);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }


    @PostMapping("/savePlayer")
    public ResponseEntity<Object> addPlayer(@RequestBody Player player ) {
            String res =  mazeGame.addPlayer(player);
            ServiceResponse<String> response = new ServiceResponse<String>("success", res);
            return new ResponseEntity<Object>( response, HttpStatus.OK);
    }

    @GetMapping("/getPlayers")
    public ResponseEntity<Object> getAllPlayers() {
        ServiceResponse<List<Player>> response = new ServiceResponse<>("success", mazeGame.getPlayers());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/saveCommand")
    public ResponseEntity<Object> addCommand(@RequestBody Commander commander ) {
        String res = mazeGame.processCommand(commander , gameMap );
        ServiceResponse<String> response = new ServiceResponse<String>("success", res);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
