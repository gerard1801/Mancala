package mancala.domain;


public class Player {

    public String name;
    public boolean active;
    public Player opponent;
    public String winner;

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

    public void switchPlayer(Player player, Pit pit) {
            player.active = false;
            player.opponent.active = true;
    }

    public String getName() {
        return this.name;
    }

    public boolean getActive(){
        return this.active;
    }

    public void setWinner(String winner) {
        this.winner = winner; }

    public String getWinner() {
        return this.winner; }
}
