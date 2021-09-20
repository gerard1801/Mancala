package mancala.domain;

public class Mancala extends Pit{
    //private String owner;
    //public Pit neighbor;
    //private int stones;

    private int testIndex;

    public Mancala(int i, Pit pit, Player player) {
        super(i, pit, player);
        super.stones = 0;
        //super.owner = player.name;
        //this.neighbour = new Pit(++i, pit, player);
        //this.testIndex = i;
    }

    public int getStones() {
        return this.stones;
    }
}
