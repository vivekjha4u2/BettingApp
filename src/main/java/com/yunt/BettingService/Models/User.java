package com.yunt.BettingService.Models;

import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String userName;
    private Wallet wallet;
}
