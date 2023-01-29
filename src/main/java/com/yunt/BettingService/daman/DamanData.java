package com.yunt.BettingService.daman;

import java.util.List;

public class DamanData {
    private int pageno;
    private int totalpage;
    private List<Game> gameslist;

    public DamanData() {
    }

    public DamanData(int pageno, int totalpage, List<Game> gameslist) {
        this.pageno = pageno;
        this.totalpage = totalpage;
        this.gameslist = gameslist;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public List<Game> getGameslist() {
        return gameslist;
    }

    public void setGameslist(List<Game> gameslist) {
        this.gameslist = gameslist;
    }
}
