package mancala.domain;

public class Pit{

    public Pit neighbour;
    private int stones;

    //private String owner;
    public int testIndex;


    public Pit(int stones) {
        //super(name, beurt);
        this.neighbour = new Pit(1, this);
        this.stones = stones;
        this.testIndex = testIndex;
        //this.owner = owner;
    }

    public Pit(int i, Pit pit) {
        this.stones = 4;

        if(i < 5) {
            this.neighbour = new Pit(++i, pit);
        } else if (i == 5) {
            this.neighbour = new Mancala(++i, pit);
        } else if (i < 12) {
            this.neighbour = new Pit(++i, pit);
        }
        else if (i == 12){
            this.neighbour = new Mancala(++i, pit);
        }
        this.testIndex = i;
    }

    public int getStones() {
        return this.stones;
    }

    public void play() {
        passStonesToNeighbour(this.stones);
        this.stones = 0;
    }

    public Pit passStonesToNeighbour(int stonesAmount) {
        this.neighbour.stones ++;
        stonesAmount --;
        if (stonesAmount > 0) {
            this.neighbour.passStonesToNeighbour(stonesAmount);
        } return this;
    }

    public Pit getNeighbour(int index) {
        if (index > 1) {
            this.neighbour = this.neighbour.neighbour;
            getNeighbour(index - 1);
            return this.neighbour;
        } else {
            return this.neighbour;
        }
    }
}