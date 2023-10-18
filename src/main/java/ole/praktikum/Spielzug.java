package ole.praktikum;

import java.util.Scanner;

public class Spielzug {
    public void zug(Spielfeld spielfeld, Spieler aktiverSpieler) {
        int[] koordinaten = new int[3];
        boolean wertpruefen = true;
        boolean feldIstFrei = false;
        Eingabeanpassen eingabeanpassen = new Eingabeanpassen();
        while (!feldIstFrei || wertpruefen) {


            System.out.println("Spieler "+aktiverSpieler.getSpielerNummer()+": Auf welches Feld willst du ein "+aktiverSpieler.getSpielFigur()+" setzen?");


            Scanner scanner = new Scanner(System.in);
            String position = scanner.nextLine();

            if (eingabeanpassen.pruefenwerte(position)) {
                koordinaten = eingabeanpassen.Umschreiben(position);
                wertpruefen = false;
            }

            if ((spielfeld.abfragespielstein(koordinaten[0], koordinaten[1]).equals(spielfeld.leeresFeld))) {
                feldIstFrei = true;
            } else {
                System.out.println("Feld schon belegt!!!");
            }
            if ((wertpruefen)) {
                System.out.println("Falsche Eingabe");
            }
        }

            spielfeld.setztenspielstein(koordinaten[0], koordinaten[1], aktiverSpieler.getSpielFigur());

    }
}//Prüft ob das Feld noch frei ist. Informationen vom Spielfeld
