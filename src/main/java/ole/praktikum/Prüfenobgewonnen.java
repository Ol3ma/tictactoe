package ole.praktikum;
import java.util.Arrays;
public class Prüfenobgewonnen {

    private boolean Pruefendreigleiche(int eins,int zwei,int drei){
        if (eins == zwei && zwei == drei){
            return true;
        }
        else{
            return false;
        }
    }
    public int prüfen(int[][] feld){
        for(int i = 0;i<3;i++) {
            if (!(feld[i][0] == 0) && Pruefendreigleiche(feld[i][0], feld[i][1], feld[i][2])) {
                return feld[i][0];
            }
        }
        for(int j = 0;j<3;j++) {
            if (!(feld[0][j] == 0) && Pruefendreigleiche(feld[0][j], feld[1][j], feld[2][j])) {
                return feld[0][j];
            }
        }
        if (!(feld[2][2] == 0) && Pruefendreigleiche(feld[0][2], feld[1][1], feld[2][0])) {
            return feld[1][1];
        }
        if (!(feld[0][0] == 0) && Pruefendreigleiche(feld[1][1], feld[2][2], feld[0][0])) {
            return feld[0][0];
        }
        if(!(Arrays.asList(feld).contains(0))){
            return 3;
        }
        return 0;
    }

}//Prüft ob gewonnen wurde. Bekommt vom Spielfeld den Stand
