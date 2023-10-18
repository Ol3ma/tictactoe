package ole.praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EingabeanpassenTest {
    @Test
    void testenfehlerhafteeingabe() {
        Eingabeanpassen sut = new Eingabeanpassen();

        boolean test = sut.pruefenwerte("Ihrgendeinmüll");
        assertFalse(test);
    }


    @Test
    void pruefenkoordinaten() {
        Eingabeanpassen sut = new Eingabeanpassen();
        int[] richtigekoordinaten = {0,1};
        int[] gegebendekoordinaten = new int[2];

        gegebendekoordinaten = sut.Umschreiben("12");

        assertArrayEquals(richtigekoordinaten,gegebendekoordinaten);
    }
}
