package mancala.domain;


public class Player {

    public String name;
    public boolean active;
    public Player opponent;

    public Player() {
    }

    public Player(String name, boolean active) {
        this.name = name;
        this.active = active;

        this.opponent = new Player(this);
    }

    public Player(Player opponent) {
        this.opponent = opponent;
    }

    //public Player getOpponent(){
    //    return this.opponent;
    //}

    public String getName() {
        return this.name;
    }

    public boolean getActive(){
        return this.active;
    }
}
