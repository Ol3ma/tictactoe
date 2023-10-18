package ole.praktikum;

public class Ablauf {

    public static void main(String[] args) {
        Spieler spieler1 = new Spieler(1,"Kreuz");
        Spieler spieler2 = new Spieler(2,"Kreis");

        Spieler aktiverSpieler = spieler1;

        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen pruefenobgewonnen = new Pruefenobgewonnen();
        Spielzug spielzug = new Spielzug();
        while (pruefenobgewonnen.pruefen(spielfeld) == 0) {
            spielzug.zug(spielfeld, aktiverSpieler);

            if (aktiverSpieler.equals(spieler1)) {
                aktiverSpieler = spieler2;
            } else {
                aktiverSpieler = spieler1;
            }

            System.out.println(spielfeld.abfragespielstein(0,0)+" | "+spielfeld.abfragespielstein(1,0)+" | "+spielfeld.abfragespielstein(2,0));
            System.out.println("-----------");
            System.out.println(spielfeld.abfragespielstein(0,1)+" | "+spielfeld.abfragespielstein(1,1)+" | "+spielfeld.abfragespielstein(2,1));
            System.out.println("-----------");
            System.out.println(spielfeld.abfragespielstein(0,2)+" | "+spielfeld.abfragespielstein(1,2)+" | "+spielfeld.abfragespielstein(2,2));
        }
        if (pruefenobgewonnen.pruefen(spielfeld) == 3){
        System.out.println("Unentschieden");
        } else if (pruefenobgewonnen.pruefen(spielfeld) == 1) {
            System.out.println("Kreis hat Gewonnen");
        } else if (pruefenobgewonnen.pruefen(spielfeld) == 2) {
            System.out.println("Kreuz hat Gewonnen");
        }
    }

}//enthält welcher Spieler am zug ist
