package mancala.domain;

public class Pit extends Player{

    public Pit neighbour;
    private int stones;
    public String owner;

    public int testIndex;


    public Pit(int stones, Player player) {
        super(player);

        this.neighbour = new Pit(1,this, player);
        this.stones = stones;
        this.owner = player.getName();
        this.testIndex = 1;
    }

    public Pit(int stones) {

        this.neighbour = new Pit(1, this, new Player("gerardTest", true));
        this.stones = stones;
        //this.owner = name;

        this.testIndex = testIndex;
    }



    public Pit(int i, Pit pit, Player player) {
        super(player);
        this.stones = 4;
        if (i < 7) {
            this.neighbour = new Pit(++i, pit, player);
            this.owner = player.getName();
        } else if (i == 7) {
            this.neighbour = new Mancala(++i, pit, player);
            this.owner = player.getName();
        } else if (i < 14) {
            this.neighbour = new Pit(++i, pit, player);
            this.owner = player.opponent.getName();
        }
        else if (i == 14){
            this.neighbour = new Mancala(++i, pit, player);
            this.owner = player.opponent.getName();
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

    //public void checkIfCurrentPlayerIsOwner() {
    //    if (player.name == this.owner) {
    //        return true;
            //play();
    //    } else return false;
   // }

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