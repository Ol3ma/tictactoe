package ole.praktikum;

public class Ablauf {

    public static void main(String[] args) {
        boolean spielereinsdran = true;
        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen pruefenobgewonnen = new Pruefenobgewonnen();
        Spielzug spielzug = new Spielzug();
        while (pruefenobgewonnen.prüfen(spielfeld) == 0) {
            spielzug.zug(spielfeld, spielereinsdran);

            spielereinsdran = !spielereinsdran;

            System.out.println(spielfeld.abfragespielstein(0,0)+" | "+spielfeld.abfragespielstein(1,0)+" | "+spielfeld.abfragespielstein(2,0));
            System.out.println("-----------");
            System.out.println(spielfeld.abfragespielstein(0,1)+" | "+spielfeld.abfragespielstein(1,1)+" | "+spielfeld.abfragespielstein(2,1));
            System.out.println("-----------");
            System.out.println(spielfeld.abfragespielstein(0,2)+" | "+spielfeld.abfragespielstein(1,2)+" | "+spielfeld.abfragespielstein(2,2));
        }
        if (pruefenobgewonnen.prüfen(spielfeld) == 3){
        System.out.println("Unentschieden");
        } else if (pruefenobgewonnen.prüfen(spielfeld) == 1) {
            System.out.println("Kreis hat Gewonnen");
        } else if (pruefenobgewonnen.prüfen(spielfeld) == 2) {
            System.out.println("Kreuz hat Gewonnen");
        }
    }

}//enthält welcher Spieler am zug ist
