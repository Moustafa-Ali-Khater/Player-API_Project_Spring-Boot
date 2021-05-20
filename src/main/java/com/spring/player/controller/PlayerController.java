package com.spring.player.controller;

import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// http://localhost:8080/
@Controller
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // http://localhost:8080/players
    @GetMapping("/players")
    public String getAllPlayers(Model model){
        model.addAttribute("players",playerService.allPlayers());
        return "home";
    }
}