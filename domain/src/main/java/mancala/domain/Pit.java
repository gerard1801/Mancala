package mancala.domain;

public class Pit extends Player{

    public Pit neighbour;
    protected int stones;
    public String owner;

    public int testIndex;


    public Pit(int stones, Player player) {
        super(player);
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

    public Pit getNeighbour(int index) {
        if (index > 1) {
            return this.neighbour.getNeighbour(--index);
        }
        return this.neighbour;
    }

    public void play(Player player) {
        if (player.getActive() == true) {
            passStonesToNeighbour(this.stones, player);
            this.stones = 0;
            //if (this instanceof Pit) {
            switchPlayer(player);
            //}
                //switchPlayer(player);
            //}
            //switchPlayer(player);
        }
    }

    public void passStonesToNeighbour(int stonesAmount, Player player) {
        if (this instanceof Mancala) {
            //if (this.owner.equals(player.getName()) && stonesAmount == 0) {
                //play again;
                //switchPlayer(player);
            //}
            if (this.owner.equals(player.getName())) {
                this.stones++;
                this.neighbour.passStonesToNeighbour(--stonesAmount, player);
            } else {
                this.neighbour.passStonesToNeighbour(stonesAmount, player);
            }
        } else {
            this.stones++;
            if (this.stones == 1 && stonesAmount == 0) {
                int oppositeStones = stealStones(player);
                addStolenStonesToMancala(player, oppositeStones + this.stones, this);
                this.stones = 0;
            } else if (stonesAmount > 0) {
                this.neighbour.passStonesToNeighbour(--stonesAmount, player);
            }
        }
    }

    public int stealStones(Player player) {
        int oppositeStones = this.getNeighbour(14-2*(this.testIndex%7)).stones;
        this.getNeighbour(14-2*(this.testIndex%7)).stones = 0;
        return oppositeStones;
    }

    public void addStolenStonesToMancala(Player player, int stolenStones, Pit pit) {
        if (pit instanceof Mancala) {
            if (player.getName().equals(pit.owner)) {
                pit.stones += stolenStones;
            }
        } else {
            addStolenStonesToMancala(player, stolenStones, pit.getNeighbour(1));
        }
    }

    public void switchPlayer(Player player) {
            player.active = false;
            player.opponent.active = true;
    }

    public void didGameFinish() {

    }
}