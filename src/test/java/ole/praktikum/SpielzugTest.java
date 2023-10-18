package ole.praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpielzugTest {

    @Test
    void pruefenobfeldbelegt(){

        //given
        Spielfeld spielfeld = new Spielfeld();
        Spielzug sut = new Spielzug();
        //when
        spielfeld.setztenspielstein(1,1,1);
        sut.zug(spielfeld,true);
        int werteinseins = spielfeld.abfragespielstein(1,1);
        //then
        assertEquals(1,werteinseins);
    }
}