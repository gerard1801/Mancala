package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    @Test
    public void PlayerhasOpponent() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        assertEquals("henk", playerOne.opponent.name);
        assertEquals("gerard", playerOne.name);
    }

    @Test
    public void onlyPlayerOneIsActive() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        assertEquals(true, playerOne.getActive());
        assertEquals(false, playerTwo.getActive());
    }
/*
    @Test
    public void checkWinner() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(playerOne);
        pit.stones = 0;
        pit.getNeighbour(1).stones = 0;
        pit.getNeighbour(2).stones = 0;
        pit.getNeighbour(3).stones = 0;
        pit.getNeighbour(4).stones = 0;
        pit.getNeighbour(5).stones = 1;
        pit.getNeighbour(5).play(playerOne);
        //pit.setWinner("gerard");
        //assertEquals(25, pit.getNeighbour(6).getStones());
        assertEquals("gerard", pit.getWinner());
    }
*/
}
