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
        Pit pit = new Pit(4);
        assertEquals(4, pit.getStones());
        pit.play();
        assertEquals(0, pit.getStones());
    }

    @Test
    //heeft de pit een buurman?
    public void pitHasANeigbour() {
        Pit pit = new Pit(4);
        assertEquals(pit.neighbour.testIndex, 2);
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
        Pit pit = new Pit(4);
        pit.play();
        assertEquals(5, pit.getNeighbour(1).getStones());
        assertEquals(5, pit.getNeighbour(3).getStones());
        assertEquals(0, pit.getStones());
    }

    @Test
    //zijn de mancala's leeg?
    public void areTheMancalaClassesEmpty() {
        Pit pit = new Pit(4);
        //assertEquals(0, pit.getNeighbour(6).getStones());
        assertEquals(0, pit.getNeighbour(13).getStones());
    }
}