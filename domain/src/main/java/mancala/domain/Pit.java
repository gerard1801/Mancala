package mancala.domain;

public class Pit extends Player{

    public Pit neighbour;
    protected int stones;
    public String owner;

    public int testIndex;
    public int stonesLeft;

    public Pit(Player player) {
        super(player);
        this.neighbour = new Pit(2,this, player);
        this.stones = 4;
        this.owner = player.getName();
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
            didGameFinish(this);

            if (this.stonesLeft > 0) {
                switchPlayer(player, this);
            }
        }
    }

    public void passStonesToNeighbour(int stonesAmount, Player player) {
        if (this instanceof Mancala) {
            if (stonesAmount == 0 && this.owner.equals(player.getName())) {
                switchPlayer(player, this);
            }
            if (this.owner.equals(player.getName()) && stonesAmount > 0) {
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

    public void didGameFinish(Pit pit) {
        if (pit instanceof Mancala) {
            int stonesLeftInPit = pit.getNeighbour(8).stones + pit.getNeighbour(9).stones + pit.getNeighbour(10).stones +
                    pit.getNeighbour(11).stones + pit.getNeighbour(12).stones + pit.getNeighbour(13).stones;
            if (stonesLeftInPit == 0) {
                int opponentStonesLeft = pit.getNeighbour(15).stones + pit.getNeighbour(16).stones + pit.getNeighbour(17).stones +
                        pit.getNeighbour(18).stones + pit.getNeighbour(19).stones + pit.getNeighbour(20).stones;
                pit.stones += opponentStonesLeft;
                checkWinner(pit);
            } else{
                setStonesLeftInPits(stonesLeftInPit);
            }
        } else {
            didGameFinish(pit.getNeighbour(1));
        }
    }

    public void checkWinner(Pit pit) {
        if (pit.stones > pit.getNeighbour(7).stones) {
            System.out.println(pit.owner + " has won the game!");
            pit.setWinner(pit.owner);

        } else if (pit.stones < pit.getNeighbour(7).stones){
            System.out.println(pit.getNeighbour(7).owner + " has won the game!");
            pit.setWinner(pit.getNeighbour(7).owner);

        } else {
            System.out.println("The game ended in a draw.");
            pit.setWinner("draw");
        }
    }

    private void setStonesLeftInPits(int stonesLeft) { this.stonesLeft = stonesLeft; }

    public int getStonesLeftInPits() { return this.stonesLeft; }

    public int getStones() { return this.stones; }


}