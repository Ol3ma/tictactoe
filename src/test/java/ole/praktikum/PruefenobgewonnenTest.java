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
    @Test
    void testunendschieden() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when
        for(int i = 0;3 > i;i++) {
            for (int j = 0; 3 > j; j++) {
                spielfeld.setztenspielstein(i, j, 3);
            }
        }
        int ergebnis = sut.pruefen(spielfeld);

        // then
        assertEquals(3, ergebnis);
    }
    @Test
    void testgewonnenspielereins() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when

            for (int j = 0; 3 > j; j++) {
                spielfeld.setztenspielstein(0, j, 1);
            }

        int ergebnis = sut.pruefen(spielfeld);

        // then
        assertEquals(1, ergebnis);
    }
    @Test
    void testgewonnenspielerzwei() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when

        for (int j = 0; 3 > j; j++) {
            spielfeld.setztenspielstein(j, 0, 2);
        }

        int ergebnis = sut.pruefen(spielfeld);

        // then
        assertEquals(2, ergebnis);
    }
}