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

    @Test
    public void switchActiveAfterPlayerOneMove() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(playerOne);
        pit.play(playerOne);

        assertEquals(false, playerOne.getActive());
        assertEquals(true, playerTwo.getActive());
    }

    @Test
    public void switchActiveAfterPlayerTwoMove() {
        Player playerOne = new Player("gerard", false);
        Player playerTwo = new Player("henk", true);
        playerOne.opponent = playerTwo;
        playerTwo.opponent = playerOne;
        Pit pit = new Pit(playerOne);
        pit.play(playerTwo);

        assertEquals(true, playerOne.getActive());
        assertEquals(false, playerTwo.getActive());
    }

    @Test
    public void didNotSwitchPlayerWhenLastIsMancala() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(playerOne);
        pit.getNeighbour(2).play(playerOne);

        assertEquals(true, playerOne.getActive());
        assertEquals(false, playerTwo.getActive());
    }
}
