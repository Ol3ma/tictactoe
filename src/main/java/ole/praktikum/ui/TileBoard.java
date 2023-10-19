package ole.praktikum.ui;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import ole.praktikum.Pruefenobgewonnen;
import ole.praktikum.Spieler;
import ole.praktikum.Spielfeld;
import ole.praktikum.Spielzug;


public class TileBoard {

    Spielzug spielzug = new Spielzug();
    Pruefenobgewonnen pruefenobgewonnen = new Pruefenobgewonnen();

    private StackPane pane;
    private InfoCenter infoCenter;
    private final Spielfeld spielfeld;

    private Tile[][] tieles = new Tile[3][3];
    public TileBoard(InfoCenter infoCenter, Spielfeld spielfeld){
        this.infoCenter = infoCenter;
        this.spielfeld = spielfeld;
        pane = new StackPane();
        pane.setMinSize(UIConstants.appwidth,UIConstants.gameboardheight);
        pane.setTranslateX(UIConstants.appwidth / 2);
        pane.setTranslateY(UIConstants.gameboardheight / 2 + UIConstants.infocenterheight);

        addAllTiles();
    }

    private void addAllTiles() {
        for (int row = 0; row < 3; row++){
            for (int col=0;col<3;col++){
                Tile tile = new Tile();
                tile.getStackPane().setTranslateX((col*100)-100);
                tile.getStackPane().setTranslateY((row*100)-100);
                pane.getChildren().add(tile.getStackPane());

                int finalRow = row;
                int finalCol = col;
                tile.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String neuerSpielsteinText) {
                    spielfeld.setztenspielstein(finalRow, finalCol, neuerSpielsteinText);
                    }
                });

                tieles[row][col] = tile;
            }
        }
    }

    public StackPane getStackPane(){
        return  pane;
    }
    private Spieler spieler1 = new Spieler("1","X");
    private Spieler spieler2 = new Spieler("2","0");
    private Spieler aktiverSpieler = spieler2;
    private Spieler playaktiverSpieler(){
        if(aktiverSpieler.equals(spieler1)) {
            aktiverSpieler = spieler2;
        } else {
            aktiverSpieler = spieler1;
        }
        return aktiverSpieler;
    }
    private class Tile {
        private StackPane pane;
        private Label label;


        public Tile() {
            pane = new StackPane();
            pane.setMinSize(100, 100);

            Rectangle border = new Rectangle();
            border.setWidth(100);
            border.setHeight(100);
            border.setFill(Color.TRANSPARENT);
            border.setStroke(Color.BLACK);

            pane.getChildren().add(border);

            label = new Label(spielfeld.leeresFeld);
            label.setAlignment(Pos.CENTER);
            label.setFont(Font.font(24));
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> {
                if(!(pruefenobgewonnen.pruefenobgewonnen(spielfeld))&&!(pruefenobgewonnen.pruefenunendschieden(spielfeld))){
                label.setText(playaktiverSpieler().getSpielFigur());
                }
                if(pruefenobgewonnen.pruefenobgewonnen(spielfeld)){
                    Gewonnen(aktiverSpieler);
                }
                if(pruefenobgewonnen.pruefenunendschieden(spielfeld)) {
                    Unendschieden();
                }
            });
        }

        public StringProperty textProperty(){
            return label.textProperty();
        }

        public StackPane getStackPane() {
            return pane;
        }

        public String getValue() {
            return label.getText();
        }
        public void setValue(String value) {
                label.setText(value);
        }
        public void Gewonnen(Spieler gewonnenderSpieler){
            infoCenter.updateMessage("Spieler "+gewonnenderSpieler.getSpielerNummer()+" hat gewonnen");
        }
        public void Unendschieden(){
            infoCenter.updateMessage("Unendschieden");
        }

    }
}

