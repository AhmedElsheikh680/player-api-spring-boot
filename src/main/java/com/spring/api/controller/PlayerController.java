package com.spring.api.controller;

import com.spring.api.model.Player;
import com.spring.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    // http://localhost:8080/api/v1/players
    @GetMapping("/players")
    public List<Player> players() {
        return playerService.players();
    }
    // http://localhost:8080/api/v1/player/1
    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
       Player player =  playerService.getPlayer(id);
       if(player ==null ){
           throw new RuntimeException("Player Not Found ID: "+id);
       }
       return player;
    }
}
