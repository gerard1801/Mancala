package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MancalaTest {

    @Test
    public void PitIsEmpty() {
        Pit pit = new Pit(4);
        //Mancala mancala = new Mancala(1, pit);
        //assertEquals(0, mancala.getStones());
    }
}