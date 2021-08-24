package mancala.domain;

public class Pit extends Player{

    public Pit neighbour;
    protected int stones;
    public String owner;

    public int testIndex;


    public Pit(int stones, Player player) {
        super(player);
        //i=0;
        this.neighbour = new Pit(2,this, player);
        this.stones = stones;
        this.owner = player.getName();
        this.testIndex = 1;
    }

    //only tests
    public Pit(int stones) {
        this.neighbour = new Pit(2, this, new Player("gerardTest", true));
        this.stones = stones;
        this.testIndex = 1;
    }

    public Pit(int i, Pit pit, Player player) {
        super(player);
        this.testIndex = i;
        if(i<=7){
            this.owner = player.name;
        } else {
            this.owner=player.opponent.name;
        }
        this.stones=4;
        if (i < 6) {
            this.neighbour = new Pit(i+1, pit, player);
        } else if (i == 6) {
            this.neighbour = new Mancala(i+1, pit, player);
        } else if (i < 13) {
            this.neighbour = new Pit(i+1, pit, player);
        }
        else if (i == 13){
            this.neighbour = new Mancala(i+1, pit, player);
        } else if (i == 14) {
            this.neighbour = pit;
        }
    }

    public int getStones() {
        return this.stones;
    }

    public void play(Player player) {
        passStonesToNeighbour(this.stones, player);
        this.stones = 0;
    }

    public void passStonesToNeighbour(int stonesAmount, Player player) {
        if (this instanceof Mancala) {
            if (this.owner.equals(player.getName())) {
                this.stones++;
                this.neighbour.passStonesToNeighbour(--stonesAmount, player);
            } else {
                this.neighbour.passStonesToNeighbour(stonesAmount, player);
            }
        } else {
            this.stones++;
            //moet bij 1 kijken, eigen veranderen.
            if (stonesAmount == 0 && this.stones == 1) {
                stealStones(player);
            }
            else if (stonesAmount > 0) {
                this.neighbour.passStonesToNeighbour(--stonesAmount, player);
            }
        }

        //if (stonesAmount == 1) {
        //    this.stones++;
        //    this.neighbour.passStonesToNeighbour(--stonesAmount, player);
        //    stealStones(player);
            //if (this.owner.equals(player.getName())) { speel nog een keer};
        //}
    }

    public void stealStones(Player player) {
        System.out.println("");//if (this.stones = 1) {
    }

    public Pit getNeighbour(int index) {
        if (index > 1) {
            return this.neighbour.getNeighbour(--index);
        }
        return this.neighbour;
        /*this.neighbour = this.neighbour.neighbour;
            getNeighbour(index - 1);
            return this.neighbour;
        } else {
            return this.neighbour;
        }*/
    }


    //public void checkIfCurrentPlayerIsOwner() {
    //    if (player.name == this.owner) {
    //        return true;
    //play();
    //    } else return false;
    // }

    /*
    public void play(int index) {
        this.neighbour = getNeighbour(index);
        passStonesToNeighbour(this.stones);
        this.stones = 0;
    }
    */
}