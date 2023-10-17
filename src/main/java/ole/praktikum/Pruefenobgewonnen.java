package ole.praktikum;
import java.util.Arrays;
public class Pruefenobgewonnen {

    private boolean Pruefendreigleiche(int eins,int zwei,int drei){
        if (eins == zwei && zwei == drei){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 0 = nicht zuende
     * 1 = Spieler 1 hat gewonnen
     * 2 = Spieler 2 hat gewonnen
     * 3 = Unendschieden
     * @param spielfeld
     * @return
     */
    public int prüfen(Spielfeld  spielfeld){
        for(int i = 0;i<3;i++) {
            if (!(spielfeld.abfragespielstein(i,0) == 0) && Pruefendreigleiche(spielfeld.abfragespielstein(i,0), spielfeld.abfragespielstein(i,1), spielfeld.abfragespielstein(i,2))){
                return spielfeld.abfragespielstein(i,0);
            }
        }
        for(int j = 0;j<3;j++) {
            if (!(spielfeld.abfragespielstein(0,j) == 0) && Pruefendreigleiche(spielfeld.abfragespielstein(0,j), spielfeld.abfragespielstein(1,j), spielfeld.abfragespielstein(2,j))) {
                return spielfeld.abfragespielstein(0,j);
            }
        }
        if (!(spielfeld.abfragespielstein(2,2) == 0) && Pruefendreigleiche(spielfeld.abfragespielstein(0,2),spielfeld.abfragespielstein(1,1), spielfeld.abfragespielstein(2,0))) {
            return spielfeld.abfragespielstein(1,1);
        }
        if (!(spielfeld.abfragespielstein(0,0) == 0) && Pruefendreigleiche(spielfeld.abfragespielstein(0,0), spielfeld.abfragespielstein(2,2), spielfeld.abfragespielstein(1,1))) {
            return spielfeld.abfragespielstein(1,1);
        }
        if(!(spielfeld.istenthalten(0))){
            return 3;
        }
        return 0;
    }

}//Prüft ob gewonnen wurde. Bekommt vom Spielfeld den Stand
