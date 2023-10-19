package ole.praktikum;


import java.util.Arrays;

public class Spielfeld {

    public final String leeresFeld = " ";

    private String[][] feld_arr = {{leeresFeld,leeresFeld,leeresFeld},
            {leeresFeld,leeresFeld,leeresFeld},
            {leeresFeld,leeresFeld,leeresFeld}}; // 0 gleich leer, 1 gleich kreuz, 2 gleich kreis


    public String abfragespielstein(int x, int y){
        return feld_arr[x][y];
    }
    public void setztenspielstein(int x, int y, String wert){
        feld_arr[x][y] = wert;
    }
    public boolean istenthalten(String feld){

        for(int i = 0;3>i;i++) {
            for(int j = 0;3>j;j++){
                if(feld.equals(feld_arr[i][j])){
                    return true;
                }
            }
        }
        return false;
    }

}//enthält koordinaten 3x3 mit dem Zustand des Feldes
