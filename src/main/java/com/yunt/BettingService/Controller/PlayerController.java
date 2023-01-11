package com.yunt.BettingService.Controller;

import com.yunt.BettingService.Models.Player;
import com.yunt.BettingService.Service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;

    @PostMapping("/savePlayer")
    Player savePlayerForBetting(@RequestBody Player player){
        // validate Player details like amount in wallet

        logger.info("PlayerController savePlayerForBetting() player: {}, time: {}", player, System.currentTimeMillis());
        return playerService.savePlayer(player);
    }
}
