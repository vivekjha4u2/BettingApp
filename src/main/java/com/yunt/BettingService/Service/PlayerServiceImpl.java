package com.yunt.BettingService.Service;

import com.yunt.BettingService.Models.Player;
import com.yunt.BettingService.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> fetchPlayers() {
        return (List<Player>) playerRepository.findAll();
    }
}
