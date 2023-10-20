package ole.praktikum.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import ole.praktikum.Spieler;

;

public class Scoreboard {
    public VBox getVbox() {
        return vbox;
    }

    private VBox vbox;
    private Label[] massage;
    private StackPane stackPane;
    public Scoreboard(Spieler[]  spieler){
        vbox = new VBox();
        massage = new Label[2];
        for(int i = 0;i< spieler.length;i++){
            massage[i] = new Label("Spieler "+spieler[i].getSpielFigur()+" hat "+spieler[i].getGewonnendeSpiele()+" mal Gewonnen");
        }
        vbox.getChildren().addAll(massage);

    }
    public void updateScoreboard(Spieler[] spieler){
        for(int i = 0;i< spieler.length;i++){
            massage[i].setText("Spieler "+spieler[i].getSpielFigur()+" hat "+spieler[i].getGewonnendeSpiele()+" mal Gewonnen");
        }
    }
}
