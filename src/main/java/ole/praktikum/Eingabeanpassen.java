package ole.praktikum;

public class Eingabeanpassen {
    public int[] Umschreiben(String position) {
        int[] koordinaten = new int[3];
        if (position.charAt(0) == '1') {
            koordinaten[0] = 0;
        } else if (position.charAt(0) == '2') {
            koordinaten[0] = 1;
        } else if (position.charAt(0) == '3') {
            koordinaten[0] = 2;
        }

        if (position.charAt(1) == '1') {
            koordinaten[1] = 0;
        } else if (position.charAt(1) == '2') {
            koordinaten[1] = 1;
        } else if (position.charAt(1) == '3') {
            koordinaten[1] = 2;
        }
        return koordinaten;
    }
    public boolean pruefenwerte(String position) {
        boolean yinpruefung = true;
        boolean xinpruefung = true;
        if (position.charAt(0) == '1') {
            xinpruefung = false;
        } else if (position.charAt(0) == '2') {
            xinpruefung = false;
        } else if (position.charAt(0) == '3') {
            xinpruefung = false;
        }

        if (position.charAt(1) == '1') {
            yinpruefung = false;
        } else if (position.charAt(1) == '2') {
            yinpruefung = false;
        } else if (position.charAt(1) == '3') {
            yinpruefung = false;
        }
        return !(yinpruefung || xinpruefung);
    }
}

