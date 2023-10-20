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
       boolean ergebnis = sut.pruefenunendschieden(spielfeld);

        // then
        assertFalse(ergebnis);
    }
    @Test
    void testunendschieden() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when
        for(int i = 0;3 > i;i++) {
            for (int j = 0; 3 > j; j++) {
                spielfeld.setztenspielstein(i, j, "T"+i+j);
            }
        }
        boolean ergebnis = sut.pruefenunendschieden(spielfeld);

        // then
        assertTrue(ergebnis);
    }
    @Test
    void testgewonnenspielereins() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when

            for (int j = 0; 3 > j; j++) {
                spielfeld.setztenspielstein(0, j, "1");
            }

        boolean ergebnis = sut.pruefenobgewonnen(spielfeld);

        // then
        assertTrue(ergebnis);
    }
    @Test
    void testgewonnenspielerzwei() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when

        for (int j = 0; 3 > j; j++) {
            spielfeld.setztenspielstein(j, 0, "2");
        }

        boolean ergebnis = sut.pruefenobgewonnen(spielfeld);

        // then
        assertTrue(ergebnis);
    }
    @Test
    void testbeivierunendschieden() {

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        // when
        for(int i = 0;2 > i;i++) {
            for (int j = 0; 2 > j; j++) {
                spielfeld.setztenspielstein(i, j, "T"+i+j);
            }
        }
        boolean ergebnis = sut.pruefenunendschieden(spielfeld);

        // then
        assertFalse(ergebnis);
    }

    @Test
    void pruefeFallNurEinSteinRechtsUnten(){

        // given
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen sut = new Pruefenobgewonnen();

        spielfeld.setztenspielstein(2,2, "X");

        // when
        boolean gewonnen = sut.pruefenobgewonnen(spielfeld);

        assertFalse(gewonnen);
    }
}