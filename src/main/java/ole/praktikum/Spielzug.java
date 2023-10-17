package ole.praktikum;

import java.util.Scanner;

public class Spielzug {
    public void zug(Spielfeld spielfeld,boolean spieler) {
        int[] koordinaten = new int[2];
        boolean yinpruefung = true;
        boolean xinpruefung = true;
        boolean feldIstFrei = true;
        while (yinpruefung && xinpruefung && feldIstFrei) {
            if (spieler) {
                System.out.println("Auf welches Feld willst du ein Kreuz setzen?");
            } else {
                System.out.println("Auf welches Feld willst du ein Kreis setzen?");
            }

            Scanner myObj = new Scanner(System.in);
            String position = myObj.nextLine();
            if (position.charAt(0) == '1') {
                koordinaten[0] = 0;
                xinpruefung=false;
            } else if (position.charAt(0) == '2') {
                koordinaten[0] = 1;
                xinpruefung=false;
            } else if (position.charAt(0) == '3') {
                koordinaten[0] = 2;
                xinpruefung=false;
            }

            if (position.charAt(1) == '1') {
                koordinaten[1] = 0;
                yinpruefung=false;
            } else if (position.charAt(1) == '2') {
                koordinaten[1] = 1;
                yinpruefung=false;
            } else if (position.charAt(1) == '3') {
                koordinaten[1] = 2;
                yinpruefung=false;
            }
            if ((spielfeld.abfragespielstein(koordinaten[0],koordinaten[1]) == 0)){
                feldIstFrei = false;
            }
            else {
                System.out.println("Feld schon belegt!!!");
            }
            if ((yinpruefung && xinpruefung && feldIstFrei)) {
                System.out.println("Falsche Eingabe");
            }

        }
        if(spieler){
            spielfeld.setztenspielstein(koordinaten[0],koordinaten[1],1 );
        }
        else {
            spielfeld.setztenspielstein(koordinaten[0],koordinaten[1],2 );
        }
    }
}//Prüft ob das Feld noch frei ist. Informationen vom Spielfeld
