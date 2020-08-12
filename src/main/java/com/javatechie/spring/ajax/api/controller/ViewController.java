package com.javatechie.spring.ajax.api.controller;


import com.javatechie.spring.ajax.api.model.maze.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Controller
public class ViewController {

    @GetMapping("/mazegame")
    public String GetMazeGame() {
        return "mazegame";
    }

    @PostMapping("/mazegame")
    public String PostMazeGame() {
        return "startplaying";
    }


    @GetMapping("/startplaying")
    public String startPlaying() {
        return "startplaying";
    }



}