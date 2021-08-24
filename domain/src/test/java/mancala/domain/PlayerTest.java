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
    public void PlayerOneIsActive() {
        Player playerOne = new Player();
        assertEquals(true, playerOne.active);
    }
*/
}
