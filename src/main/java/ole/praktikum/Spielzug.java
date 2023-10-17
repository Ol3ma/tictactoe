package ole.praktikum;

import java.util.Scanner;

public class Spielzug {
    public int[] zug(boolean spieler) {
        boolean[] fertig = {false, false};
        int[] koordinaten = new int[2];


        Scanner myObj = new Scanner(System.in);
        String position = myObj.nextLine();
        char[] char_position = position.toCharArray();
        koordinaten[0] = position.charAt(0);
        koordinaten[1] = position.charAt(1);
        return koordinaten;

    /*
    while (fertig[0] && fertig[1]) {
        if (spieler = true) {
            System.out.println("Auf welches Feld willst du ein Kreuz setzten?");
        } else {
            System.out.println("Auf welches Feld willst du ein Kreis setzten?");
        }

        Scanner myObj = new Scanner(System.in);
        String position = myObj.nextLine();
        char[] char_position = position.toCharArray();
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

        if (char_position.charAt(1) == "1") {
            koordinaten[1] = 0;
            fertig[1]=true;
        } else if (char_position.charAt(1) == "2") {
            koordinaten[1] = 1;
            fertig[1]=true;
        } else if (char_position.charAt(1) == "3") {
            koordinaten[1] = 2;
            fertig[1]=true;
        }

    }

}
*/
    }
}//Prüft ob das Feld noch frei ist. Informationen vom Spielfeld
