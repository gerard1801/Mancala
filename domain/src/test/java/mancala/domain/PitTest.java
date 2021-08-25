package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PitTest {
    @Test
    //kan ik een pit maken met 4 stenen erin?
    public void PitHas4Stones() {
        Pit pit = new Pit(4);
        assertEquals(4, pit.getStones());
    }

    @Test
    //wordt een pit leeg na een zet?
    public void pitIsEmptyAfterPlay() {
        Player playerOne = new Player("gerard", true);
        Pit pit = new Pit(4);
        assertEquals(4, pit.getStones());
        pit.play(playerOne);
        assertEquals(0, pit.getStones());
    }

    @Test
    //heeft de pit een buurman?
    public void pitHasANeigbour() {
        Pit pit = new Pit(4);
        assertEquals(2, pit.neighbour.testIndex);
    }

    @Test
    //haal data op van de buurman i x verder
    public void getNeigbourBasedOnIndex() {
        Pit pit = new Pit(4);
        //assertEquals(pit.getNeighbour(1).testIndex, 2);
        assertEquals(pit.getNeighbour(8).testIndex, 9);
    }

    @Test
    //worden de stenen doorgegeven aan de volgende buren als er een zet wordt gedaan?
    public void passStonesToNeighboursAndAddOne() {
        Player playerOne = new Player("gerard", true);
        Pit pit = new Pit(4);
        pit.play(playerOne);
        assertEquals(5, pit.getNeighbour(1).getStones());
        assertEquals(5, pit.getNeighbour(3).getStones());
        assertEquals(0, pit.getStones());
    }

    @Test
    public void checkOwners() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);
        assertEquals("gerard", pit.owner);
        assertEquals("henk", pit.getNeighbour(9).owner);
    }

    @Test
    public void AddStonesToNeighboursOnIndexOwnerIsTrue() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);

        pit.getNeighbour(4).play(playerOne);
        assertEquals(0, pit.getNeighbour(4).getStones());
        assertEquals(5, pit.getNeighbour(5).getStones());
        assertEquals(1, pit.getNeighbour(6).getStones());
        assertEquals(5, pit.getNeighbour(8).getStones());
        assertEquals(4, pit.getNeighbour(9).getStones());
    }

    @Test
    public void AddStonesToNeighboursOnIndexOwnerIsFalse() {
        Player playerOne = new Player("gerard", false);
        Player playerTwo = new Player("henk", true);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);

        pit.getNeighbour(4).play(playerOne);
        assertEquals(4, pit.getNeighbour(4).getStones());
        assertEquals(4, pit.getNeighbour(5).getStones());
    }

    @Test
    public void passMancalaIfOwnerIncorrect() {
        Player playerOne = new Player("gerard", false);
        Player playerTwo = new Player("henk", true);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);
        pit.getNeighbour(12).stones = 8;
        pit.getNeighbour(12).play(playerTwo);

        assertEquals(0, pit.getNeighbour(12).getStones());
        assertEquals(1, pit.getNeighbour(13).getStones());
        assertEquals(0, pit.getNeighbour(6).getStones());
        assertEquals(5, pit.getNeighbour(7).getStones());
    }

    @Test
    public void StealStones() {
        Player playerOne = new Player("gerard", true);
        Pit pit = new Pit(4, playerOne);
        pit.getNeighbour(4).stones = 0;
        pit.play(playerOne);
        //assertEquals(1, pit.getNeighbour(4).getStones());
        assertEquals(0, pit.getNeighbour(4).getStones());
        assertEquals(0, pit.getNeighbour(8).getStones());
    }

    @Test
    public void addStolenStonesToMancalaPlayerOne() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);
        pit.getNeighbour(4).stones = 0;
        pit.play(playerOne);

        assertEquals(5, pit.getNeighbour(6).getStones());
        assertEquals(0, pit.getNeighbour(4).getStones());
        assertEquals(0, pit.getNeighbour(8).getStones());
    }

    @Test
    public void addStolenStonesToMancalaPlayerTwo() {
        Player playerOne = new Player("gerard", false);
        Player playerTwo = new Player("henk", true);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);
        pit.getNeighbour(11).stones = 0;
        pit.getNeighbour(7).play(playerTwo);

        assertEquals(5, pit.getNeighbour(13).getStones());
        assertEquals(0, pit.getNeighbour(11).getStones());
        assertEquals(0, pit.getNeighbour(1).getStones());
    }

    @Test
    public void switchActiveAfterPlayerOneMove() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);
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
        Pit pit = new Pit(4, playerOne);
        pit.play(playerTwo);

        assertEquals(true, playerOne.getActive());
        assertEquals(false, playerTwo.getActive());
    }


    @Test
    public void didNotSwitchWhenLastIsMancala() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);
        pit.getNeighbour(2).play(playerOne);

        assertEquals(true, playerOne.getActive());
        //assertEquals(false, playerTwo.getActive());
    }







/*
    @Test
    public void isActivePlayerOwner() {
        Player playerOne = new Player("gerard", true);
        Player playerTwo = new Player("henk", false);
        playerOne.opponent = playerTwo;
        Pit pit = new Pit(4, playerOne);
        pit.play();

        //assertEquals(playerOne.name, )
    }


*/
    @Test
    //is de pit waaraan de stenen worden doorgegeven leeg?
    public void isTheLastPitEmpty() {
        Pit pit = new Pit(4);
        //pit.getNeighbour(5).stones = 0;
    }

    //pak de stenen in de tegenover gestelde pit en return de som van de pits.
}