package ole.praktikum;

public class Ablauf {

    public static void main(String[] args) {
        Spieler spieler1 = new Spieler("1","X");
        Spieler spieler2 = new Spieler("2","0");

        Spieler aktiverSpieler = spieler1;

        Spielfeld spielfeld = new Spielfeld();
        Pruefenobgewonnen pruefenobgewonnen = new Pruefenobgewonnen();
        Spielzug spielzug = new Spielzug();
        while (!(pruefenobgewonnen.pruefenobgewonnen(spielfeld) || pruefenobgewonnen.pruefenunendschieden(spielfeld))) {



            if (aktiverSpieler.equals(spieler1)) {
                aktiverSpieler = spieler2;
            } else {
                aktiverSpieler = spieler1;
            }

            spielzug.zug(spielfeld, aktiverSpieler);

            System.out.println(spielfeld.abfragespielstein(0,0)+" | "+spielfeld.abfragespielstein(1,0)+" | "+spielfeld.abfragespielstein(2,0));
            System.out.println("-----------");
            System.out.println(spielfeld.abfragespielstein(0,1)+" | "+spielfeld.abfragespielstein(1,1)+" | "+spielfeld.abfragespielstein(2,1));
            System.out.println("-----------");
            System.out.println(spielfeld.abfragespielstein(0,2)+" | "+spielfeld.abfragespielstein(1,2)+" | "+spielfeld.abfragespielstein(2,2));
        }
        if (pruefenobgewonnen.pruefenobgewonnen(spielfeld)){
            System.out.println(aktiverSpieler.getSpielFigur()+" hat Gewonnen");
        } else if (pruefenobgewonnen.pruefenunendschieden(spielfeld)) {
            System.out.println("Unentschieden");
        }
    }

}//enthält welcher Spieler am zug ist
