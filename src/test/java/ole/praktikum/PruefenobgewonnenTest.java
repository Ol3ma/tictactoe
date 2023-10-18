package ole.praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PruefenobgewonnenTest {

    @Test
    void leeresSpielfeldIst0() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when
        int ergebnis = sut.pruefen(spielfeld);

        // then
        assertEquals(0, ergebnis);
    }
    void testunendschieden() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when
        for(int i = 0;2 > i;i++) {
            for (int j = 0; 2 > j; j++) {
                spielfeld.setztenspielstein(i, j, 1);
            }
        }
        int ergebnis = sut.pruefen(spielfeld);

        // then
        assertEquals(3, ergebnis);
    }
}