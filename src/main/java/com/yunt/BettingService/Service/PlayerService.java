package com.yunt.BettingService.Service;

import com.yunt.BettingService.Models.Player;

import java.util.List;

public interface PlayerService {
    Player savePlayer(Player player);
    List<Player> fetchPlayers();

    void deletePlayers();
}
