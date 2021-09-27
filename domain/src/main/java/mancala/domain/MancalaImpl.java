package mancala.domain;

public class MancalaImpl implements Mancala {

    private Pit pit;
    private Player playerOne;
    private Player playerTwo;
    private int round;

    public MancalaImpl() {
        // Initialize the game here.
        this.playerOne = new Player("gerard", true);
        this.playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        playerTwo.opponent = playerOne;
        this.pit = new Pit(playerOne);
        this.round = 0;
    }

    @Override
    public boolean isPlayersTurn(int player) {
        return true;
    }

    @Override
	public void playPit(int index) throws MancalaException {
        // Implement playing a pit.
        if (index > 0 && this.playerOne.getActive() == true) {
            this.pit.getNeighbour(index).play(this.playerOne);
            //this.pit = this.pit.getNeighbour(index);
        } else if (index > 0 && this.playerTwo.getActive() == true) {
            this.pit.getNeighbour(index).play(this.playerTwo);
            //this.pit = this.pit.getNeighbour(index);
        } else if (index == 0 && this.playerOne.getActive() == true){
            this.pit.play(this.playerOne);
        } else if (index == 0 && this.playerTwo.getActive() == true) {
            this.pit.play(this.playerTwo);
        }
        this.round++;
    }
	
	@Override
	public int getStonesForPit(int index) {
        // Make a sane implementation.
        if (index > 0) {
            return this.pit.getNeighbour(index).getStones();
        } else {
            return this.pit.getStones();
        }
    }

	@Override
	public boolean isEndOfGame() {
        return false;

        //System.out.println(this.pit.getStonesLeftInPits());
        //return false;
        //if (this.pit.getStonesLeftInPits() > 0 || this.round == 0) {
        //    return false;
        //} else {
        //    return true;
        //}
    }

	@Override
	public int getWinner() {
        return Mancala.NO_PLAYERS;
    }
}