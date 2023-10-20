package ole.praktikum.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ole.praktikum.Spieler;
import ole.praktikum.Spielfeld;

import static javafx.application.Application.launch;

public class UIStart extends Application {

    InfoCenter infoCenter;
    TileBoard tileBoard;
    Scoreboard scoreboard;

    private Spielfeld spielfeld;


    private Spieler spieler1 = new Spieler("1", "X");
    private Spieler spieler2 = new Spieler("2", "0");

    private Spieler[] spielers = {spieler1,spieler2};


    @Override
    public void init() throws Exception {
        spielfeld = new Spielfeld();
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,UIConstants.appwidth, UIConstants.appheight);
        initLayout(root);
        primaryStage.getIcons().add(new Image("ole/praktikum/ui/Icon.png"));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setMinHeight(UIConstants.appheight+25);
        primaryStage.setMinWidth(UIConstants.appwidth+17);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    public static void main(String[] args) {
        launch(args);
    }
    private void initLayout (BorderPane root) {
        initScoreboard(root);
        initInfoCenter(root);
        initTileBoard(root);

    }

    private void initScoreboard(BorderPane root) {
        scoreboard = new Scoreboard(spielers);
        root.setBottom(scoreboard.getVbox());
    }

    private void initTileBoard(BorderPane root) {
        tileBoard = new TileBoard(infoCenter, spielfeld, scoreboard,spielers);
        root.setCenter(tileBoard.getStackPane());
    }

    private void initInfoCenter(BorderPane root) {
        infoCenter = new InfoCenter();
        infoCenter.setStartGameButtonOnAktion(startNewGame());
        root.setTop(infoCenter.getPane());
    }
    private EventHandler<ActionEvent> startNewGame() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                tileBoard.resetspiel();
            }
        };
    }
}


