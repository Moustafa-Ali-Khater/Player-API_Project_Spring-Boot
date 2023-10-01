package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;


@RestController
@RequestMapping("/api")
public class Controller {

	private PlayerService playerService;


	@Autowired
	public Controller(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping("/data")
	public String getdata() {
		return "Hallo...";
	}
	
	@GetMapping("/players")
	public List<Player> gePlayers() {
		return playerService.allPlayers();
	}
	
	@GetMapping("/players/{id}")
	public Player getplayerById(@PathVariable("id") int id) {
		Player p = playerService.showPlayer(id);
		if(p == null) {
			throw new RuntimeException("Player Not Found " + "ID: " + id);
		}
		return p;
	}
	
	/*@GetMapping("/players")
	public Player getplayerId(@RequestParam int id) {
		Player p = playerService.showPlayer(id);
		if(p == null) {
			throw new StudentException("Player Not Found " + "ID: " + id);
		}
		return p;
	}*/
	
	/*@PostMapping("/saveplayer")
	public Player saveplayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return player;
	}*/
	
	@PostMapping("/saveplayer")
	public String saveplayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Add successfully!";
	}
	
	@PutMapping("/update")
	public String updateplayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Update successfully!";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteplayer(@PathVariable ("id") int id) {
		int r = playerService.deletePlayer(id);
		//System.out.println(r);
		if (r == 0) {
			throw new RuntimeException("Player Not Found " + "ID: " + id);
		}
		return "Deleted successfully!";
	}
	
	/*@DeleteMapping("/delete")
	public void removeplayer(@RequestParam int id) {
		playerService.deletePlayer(id);
	}*/
}
