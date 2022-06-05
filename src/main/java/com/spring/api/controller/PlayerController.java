package com.spring.api.controller;

import com.spring.api.model.Player;
import com.spring.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/player")
    public Player addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
        return player;
    }

    @PutMapping("/player")
    public Player updatePlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
        return player;
    }

    @DeleteMapping("/player/{id}")
    public String deletePlayer(@PathVariable("id") int id) {
        int result = playerService.deletePlayer(id);
        if(result ==0) {
            throw new RuntimeException("Player Not Found ID: "+ id);
        }
        return "Deleted Successfully!!";
    }

















}
