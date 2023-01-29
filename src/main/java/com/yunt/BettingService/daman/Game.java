package com.yunt.BettingService.daman;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Game {
    private int rowId;
    @JsonProperty("IssueNumber")
    private String IssueNumber;
    @JsonProperty("Number")
    private String Number;
    @JsonProperty("Colour")
    private String Colour;
    @JsonProperty("Premium")
    private String Premium;

    public Game(int rowId, String issueNumber, String number, String colour, String premium) {
        this.rowId = rowId;
        this.IssueNumber = issueNumber;
        this.Number = number;
        this.Colour = colour;
        this.Premium = premium;
    }

    public Game() {
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getIssueNumber() {
        return IssueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        IssueNumber = issueNumber;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public String getPremium() {
        return Premium;
    }

    public void setPremium(String premium) {
        Premium = premium;
    }
}
