package com.javatechie.spring.ajax.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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