package ole.praktikum;

import java.util.Scanner;

public class Spielzug {
    public void zug(Spielfeld spielfeld,boolean spieler) {
        int[] koordinaten = new int[2];
        boolean fertig = true;
        while (fertig) {
            if (spieler) {
                System.out.println("Auf welches Feld willst du ein Kreuz setzten?");
            } else {
                System.out.println("Auf welches Feld willst du ein Kreis setzten?");
            }

            Scanner myObj = new Scanner(System.in);
            String position = myObj.nextLine();
            koordinaten[0] = Integer.parseInt( String.valueOf( position.charAt(0)) );
            koordinaten[1] = Integer.parseInt( String.valueOf( position.charAt(1)) );
            if ((spielfeld.abfragespielstein(koordinaten[0],koordinaten[1]) == 0)){
                fertig = false;
            }
        }
        if(spieler){
            spielfeld.setztenspielstein(koordinaten[0],koordinaten[1],1 );
        }
        else {
            spielfeld.setztenspielstein(koordinaten[0],koordinaten[1],2 );
        }

    /*
    boolean[] fertig = {false, false};
    while (fertig[0] && fertig[1]) {
        if (spieler = true) {
            System.out.println("Auf welches Feld willst du ein Kreuz setzten?");
        } else {
            System.out.println("Auf welches Feld willst du ein Kreis setzten?");
        }

        Scanner myObj = new Scanner(System.in);
        String position = myObj.nextLine();
        if (position.charAt(0) == 'a') {
            koordinaten[0] = 0;
            fertig[0]=true;
        } else if (position.charAt(0) == 'b') {
            koordinaten[0] = 1;
            fertig[0]=true;
        } else if (position.charAt(0) == 'c') {
            koordinaten[0] = 2;
            fertig[0]=true;
        }

        if (position.charAt(1) == "1") {
            koordinaten[1] = 0;
            fertig[1]=true;
        } else if (position.charAt(1) == "2") {
            koordinaten[1] = 1;
            fertig[1]=true;
        } else if (position.charAt(1) == "3") {
            koordinaten[1] = 2;
            fertig[1]=true;
        }

    }

}
*/
    }
}//Prüft ob das Feld noch frei ist. Informationen vom Spielfeld
