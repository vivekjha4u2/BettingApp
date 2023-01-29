package com.yunt.BettingService.Controller;

import com.yunt.BettingService.Models.*;
import com.yunt.BettingService.Service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@EnableScheduling
@RestController
public class BettingController {

    Logger logger = LoggerFactory.getLogger(BettingController.class);

    @Autowired
    private PlayerService playerService;

    //fetch players from db;
    private Room prepareRoom(){
        logger.info("inside prepareRoom");
        Room room = new Room();
        room.setPlayers(playerService.fetchPlayers());
        return room;
    }
    BettingParameter bp = BettingParameter.RED;
    @Scheduled(fixedDelayString = "PT1M", initialDelayString = "PT1M")
    private BettingParameter startBetting(){
        Room room = prepareRoom();
        int min = 0;
        int sumRed = 0, sumBlue = 0, sumGreen = 0;

        for(Player player: room.getPlayers()){
            switch (player.getBettingParameter()){
                case RED:
                    sumRed += player.getBetAmount();
                    break;
                case BLUE:
                    sumBlue += player.getBetAmount();
                    break;
                case GREEN:
                    sumGreen += player.getBetAmount();
            }
        }

        min = Math.min(Math.min(sumRed, sumBlue) ,sumGreen);
        if(min == sumRed) bp = BettingParameter.RED;
        else if(min == sumBlue) bp = BettingParameter.BLUE;
        else if(min == sumGreen) bp = BettingParameter.GREEN;
        logger.info("startBetting() sumRed: {}, sumBlue: {}, sumGreen: {}, Min BettingParam: {}",
                sumRed, sumBlue, sumGreen, bp);
        playerService.deletePlayers();
        return bp;
    }
    //After this remove all players from db


    //Not correct approach..
    //fetchThisRoundWinningParam
    @GetMapping("/winning-param")
    public WinningParam fetchThisRoundWinningParam(){
        WinningParam winningParam = new WinningParam();
        winningParam.setWinningParam(bp.name());
        return winningParam;
    }

    @GetMapping("/current-time")
    public MyTime getCurrentTime(){
        MyTime myTime = new MyTime();
        logger.info("Current time: {}",System.currentTimeMillis());
        myTime.setTime(System.currentTimeMillis());
        return myTime;
    }
}
