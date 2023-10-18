package ole.praktikum;

import java.util.Scanner;

public class Spielzug {
    public void zug(Spielfeld spielfeld, boolean spieler) {
        int[] koordinaten = new int[3];
        boolean wertpruefen = true;
        boolean feldIstFrei = false;
        Eingabeanpassen eingabeanpassen = new Eingabeanpassen();
        while (!feldIstFrei || wertpruefen) {
            if (spieler) {
                System.out.println("Auf welches Feld willst du ein Kreuz setzen?");
            } else {
                System.out.println("Auf welches Feld willst du ein Kreis setzen?");
            }

            Scanner scanner = new Scanner(System.in);
            String position = scanner.nextLine();

            if (eingabeanpassen.pruefenwerte(position)) {
                koordinaten = eingabeanpassen.Umschreiben(position);
                wertpruefen = false;
            }

            if ((spielfeld.abfragespielstein(koordinaten[0], koordinaten[1]) == 0)) {
                feldIstFrei = true;
            } else {
                System.out.println("Feld schon belegt!!!");
            }
            if ((wertpruefen)) {
                System.out.println("Falsche Eingabe");
            }
        }

        if (spieler) {
            spielfeld.setztenspielstein(koordinaten[0], koordinaten[1], 1);
        } else {
            spielfeld.setztenspielstein(koordinaten[0], koordinaten[1], 2);
        }
    }
}//Prüft ob das Feld noch frei ist. Informationen vom Spielfeld
