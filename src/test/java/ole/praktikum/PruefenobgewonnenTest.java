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
}