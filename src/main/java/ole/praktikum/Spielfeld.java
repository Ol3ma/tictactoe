package ole.praktikum;


import java.util.Arrays;

public class Spielfeld {

    public final String leeresFeld = " ";

    private String[][] feld_arr = new String[Constants.anzahlfelder][Constants.anzahlfelder];// 0 gleich leer, 1 gleich kreuz, 2 gleich kreis

    public Spielfeld(){
        for(int i = 0; i < Constants.anzahlfelder ;i++) {
            for(int j = 0; j < Constants.anzahlfelder ;j++) {
                feld_arr[i][j] = leeresFeld;
            }
        }
    }

    public String abfragespielstein(int x, int y){
        return feld_arr[x][y];
    }
    public void setztenspielstein(int x, int y, String wert){
        feld_arr[x][y] = wert;
    }
    public boolean istenthalten(String feld){

        for(int i = 0;Constants.anzahlfelder>i;i++) {
            for(int j = 0;Constants.anzahlfelder>j;j++){
                if(feld.equals(feld_arr[i][j])){
                    return true;
                }
            }
        }
        return false;
    }

}//enthält koordinaten 3x3 mit dem Zustand des Feldes
