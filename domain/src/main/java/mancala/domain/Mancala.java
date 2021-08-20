package mancala.domain;

public class Mancala extends Pit{
    //private String owner;
    public Pit neighbor;
    private int stones;

    private int testIndex;

    public Mancala(int i, Pit pit) {
        super(i, pit);
        this.stones = 0;
        this.neighbour = new Pit(++i, pit);
        this.testIndex = i;
    }

    public int getStones() {
        return this.stones;
    }
}
