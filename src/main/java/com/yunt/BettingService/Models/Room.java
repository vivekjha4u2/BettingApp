package com.yunt.BettingService.Models;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Room {
    private int roomId;
    private List<Player> players;
}
