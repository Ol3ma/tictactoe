package ole.praktikum;


public class Spielfeld {

    private int[][] feld_arr = new int[3][3]; // 0 gleich leer, 1 gleich kreuz, 2 gleich kreis

    /**
     * 0 = leeres Feld
     * 1 = kreuz
     * 2 = kreis
     * @param x
     * @param y
     * @return
     */
    public int abfragespielstein(int x,int y){
        return feld_arr[x][y];
    }
    public void setztenspielstein(int x,int y,int wert){
        feld_arr[x][y] = wert;
    }
}//enthält koordinaten 3x3 mit dem Zustand des Feldes
