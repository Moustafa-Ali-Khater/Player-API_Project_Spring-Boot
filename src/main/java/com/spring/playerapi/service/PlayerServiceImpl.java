package com.spring.playerapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.playerapi.dao.PlayerDAO;
import com.spring.playerapi.model.Player;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	private PlayerDAO playerDao;


	@Autowired
	public PlayerServiceImpl(PlayerDAO playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public List<Player> allPlayers() {
		// begain
		return playerDao.getPlayers();
		// commit
	}

	@Override
	public void savePlayer(Player player) {
		playerDao.addPlayers(player);
	}

	@Override
	public Player showPlayer(int id) {
		return playerDao.getPlayer(id);
	}

	@Override
	public int deletePlayer(int id) {
		// TODO Auto-generated method stub
		return playerDao.removePlayer(id);
		
	}

}
