package ole.praktikum;

public class Pruefenobgewonnen {

    private boolean Pruefendreigleiche(String eins, String zwei, String drei){
        return eins.equals(zwei) && zwei.equals(drei);
    }

    public boolean pruefenobgewonnen(Spielfeld  spielfeld){
        for (int l = 0;l < Constants.anzahlfelder-2;l++) {
            for (int k = 0; k < Constants.anzahlfelder-2; k++) {
                for (int i = 0; i < 3; i++) {
                    if (!(spielfeld.abfragespielstein(i+k, 0+l).equals(spielfeld.leeresFeld)) && Pruefendreigleiche(spielfeld.abfragespielstein(i+k, 0+l), spielfeld.abfragespielstein(i+k, 1+l), spielfeld.abfragespielstein(i+k, 2+l))) {
                        return true;
                    }
                }
                for (int j = 0; j < 3; j++) {
                    if (!(spielfeld.abfragespielstein(0+k, j+l).equals(spielfeld.leeresFeld)) && Pruefendreigleiche(spielfeld.abfragespielstein(0+k, j+l), spielfeld.abfragespielstein(1+k, j+l), spielfeld.abfragespielstein(2+k, j+l))) {
                        return true;
                    }
                }
                if (!(spielfeld.abfragespielstein(2+k, 0+l).equals(spielfeld.leeresFeld)) && Pruefendreigleiche(spielfeld.abfragespielstein(0+k, 2+l), spielfeld.abfragespielstein(1+k, 1+l), spielfeld.abfragespielstein(2+k, 0+l))) {
                    return true;
                }
                if (!(spielfeld.abfragespielstein(0+k, 0+l).equals(spielfeld.leeresFeld)) && Pruefendreigleiche(spielfeld.abfragespielstein(0+k, 0+l), spielfeld.abfragespielstein(2+k, 2+l), spielfeld.abfragespielstein(1+k, 1+l))) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean pruefenunendschieden(Spielfeld spielfeld){
        return (!pruefenobgewonnen(spielfeld)) && (!spielfeld.istenthalten(spielfeld.leeresFeld));

    }

}//Prüft ob gewonnen wurde. Bekommt vom Spielfeld den Stand
