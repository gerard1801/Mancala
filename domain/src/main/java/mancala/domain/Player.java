package mancala.domain;


public class Player {
    //welke speler aan zet is
    //wat de speler voor zet heeft gedaan
    public String name;
    //public Boolean beurt;

    public Player(String name) {
        this.name = name;
        //this.beurt = beurt;
    }

    public String getPlayer(String name) {
        return this.name;
    }
}
