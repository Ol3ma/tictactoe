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
import ole.praktikum.*;


public class TileBoard {

    Pruefenobgewonnen pruefenobgewonnen = new Pruefenobgewonnen();

    private StackPane pane;
    private InfoCenter infoCenter;
    private Scoreboard scoreboard;

    private final Spielfeld spielfeld;

    private Tile[][] tieles = new Tile[Constants.anzahlfelder][Constants.anzahlfelder];

    public TileBoard(InfoCenter infoCenter, Spielfeld spielfeld, Scoreboard scoreboard, Spieler[] spielers) {
        this.infoCenter = infoCenter;
        this.spielfeld = spielfeld;
        this.scoreboard = scoreboard;
        this.spielers = spielers;
        aktiverSpieler = spielers[1];
        pane = new StackPane();


        addAllTiles();
    }
    private Spieler[] spielers;
    private Spieler aktiverSpieler;



    public Spieler playaktiverSpieler() {
        if (aktiverSpieler.equals(spielers[0])) {
            infoCenter.updateMessage("Setzte ein " + aktiverSpieler.getSpielFigur());
            aktiverSpieler = spielers[1];
        } else {
            infoCenter.updateMessage("Setzte ein " + aktiverSpieler.getSpielFigur());
            aktiverSpieler = spielers[0];
        }
        return aktiverSpieler;
    }
    private void addAllTiles() {
        for (int row = 0; row < Constants.anzahlfelder; row++) {
            for (int col = 0; col < Constants.anzahlfelder; col++) {
                Tile tile = new Tile(row, col);
                tile.getStackPane().setTranslateX((col * 100) - 100);
                tile.getStackPane().setTranslateY((row * 100) - 100);
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

    public StackPane getStackPane() {
        return pane;
    }






    public void resetspiel() {
        aktiverSpieler.setGewonnendeSpielepluseins();
        scoreboard.updateScoreboard(spielers);
        for (int i = 0; i < Constants.anzahlfelder; i++) {
            for (int j = 0; j < Constants.anzahlfelder; j++) {
                spielfeld.setztenspielstein(i, j, spielfeld.leeresFeld);
                tieles[i][j].reset();
                infoCenter.updateMessage("Tic-Tac-Toe");
            }
        }
    }

    private class Tile {
        private StackPane pane;
        private Label label;



        public Tile(int x, int y) {
            pane = new StackPane();
            pane.setMinSize(100, 100);
            pane.setMaxSize(100,100);

            Rectangle border = new Rectangle();
            border.setWidth(100);
            border.setHeight(100);
            border.setFill(Color.TRANSPARENT);
            border.setStroke(Color.BLACK);

            pane.getChildren().add(border);

            label = new Label(spielfeld.leeresFeld);
            label.setAlignment(Pos.CENTER);
            label.setFont(Font.font(40));
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> {
                if (!(pruefenobgewonnen.pruefenobgewonnen(spielfeld)) && !(pruefenobgewonnen.pruefenunendschieden(spielfeld))) {
                    if (spielfeld.abfragespielstein(x, y).equals(spielfeld.leeresFeld)) {
                        label.setText(playaktiverSpieler().getSpielFigur());
                    } else {
                        infoCenter.updateMessage("Feld schon belegt!!!");
                    }
                }
                if (pruefenobgewonnen.pruefenobgewonnen(spielfeld)) {
                    Gewonnen(aktiverSpieler);
                }
                if (pruefenobgewonnen.pruefenunendschieden(spielfeld)) {
                    Unendschieden();
                }

            });

        }

        public StringProperty textProperty() {
            return label.textProperty();
        }

        public StackPane getStackPane() {
            return pane;
        }


        public void Gewonnen(Spieler gewonnenderSpieler) {
            infoCenter.updateMessage("Spieler " + gewonnenderSpieler.getSpielFigur() + " hat gewonnen");
        }

        public void Unendschieden() {
            infoCenter.updateMessage("Unentschieden");

        }

        public void reset() {
            label.setText(spielfeld.leeresFeld);
        }
    }
}
