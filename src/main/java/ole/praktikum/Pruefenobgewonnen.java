package ole.praktikum;

public class Pruefenobgewonnen {

    private boolean Pruefendreigleiche(int eins,int zwei,int drei){
        return eins == zwei && zwei == drei;
    }

    public boolean pruefenobgewonnen(Spielfeld  spielfeld){
        for(int i = 0;i<3;i++) {
            if (!(spielfeld.abfragespielstein(i,0) == 0) && Pruefendreigleiche(spielfeld.abfragespielstein(i,0), spielfeld.abfragespielstein(i,1), spielfeld.abfragespielstein(i,2))){
                return true;
            }
        }
        for(int j = 0;j<3;j++) {
            if (!(spielfeld.abfragespielstein(0,j) == 0) && Pruefendreigleiche(spielfeld.abfragespielstein(0,j), spielfeld.abfragespielstein(1,j), spielfeld.abfragespielstein(2,j))) {
                return true;
            }
        }
        if (!(spielfeld.abfragespielstein(2,2) == 0) && Pruefendreigleiche(spielfeld.abfragespielstein(0,2),spielfeld.abfragespielstein(1,1), spielfeld.abfragespielstein(2,0))) {
            return true;
        }
        if (!(spielfeld.abfragespielstein(0,0) == 0) && Pruefendreigleiche(spielfeld.abfragespielstein(0,0), spielfeld.abfragespielstein(2,2), spielfeld.abfragespielstein(1,1))) {
            return true;
        }

        return false;
    }
    public boolean pruefenunendschieden(Spielfeld spielfeld){
        return pruefenobgewonnen(spielfeld) && !(spielfeld.istenthalten(0));

    }

}//Prüft ob gewonnen wurde. Bekommt vom Spielfeld den Stand
