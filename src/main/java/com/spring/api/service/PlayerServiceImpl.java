package com.spring.api.service;

import com.spring.api.dao.PlayerRepo;
import com.spring.api.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public List<Player> players() {
        return playerRepo.players();
    }

    @Override
    public Player getPlayer(int id) {
        return playerRepo.getPlayer(id);
    }

    @Override
    public void addPlayer(Player player) {
        playerRepo.addPlayer(player);
    }

    @Override
    public int deletePlayer(int id) {
        return playerRepo.deletePlayer(id);
    }
}
