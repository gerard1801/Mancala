package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MancalaTest {

    @Test
    public void PitOfFirstMancalaIsEmpty() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(playerOne);
        assertEquals(0, pit.getNeighbour(6).getStones());
    }

    @Test
    public void PitOfSecondMancalaIsEmpty() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(playerOne);
        assertEquals(0, pit.getNeighbour(13).getStones());
    }

    @Test
    public void CheckFirstMancalaOwner() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(playerOne);
        assertEquals("gerard", pit.getNeighbour(6).owner);
    }

    @Test
    public void CheckSecondMancalaOwner() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(playerOne);
        assertEquals("henk", pit.getNeighbour(13).owner);
    }
}