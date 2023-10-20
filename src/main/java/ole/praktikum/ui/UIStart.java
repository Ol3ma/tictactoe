package ole.praktikum.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ole.praktikum.Spieler;
import ole.praktikum.Spielfeld;

import java.io.IOException;

import static javafx.application.Application.launch;

public class UIStart extends Application {

    InfoCenter infoCenter;
    TileBoard tileBoard;

    private Spielfeld spielfeld;


    @Override
    public void init() throws Exception {
        spielfeld = new Spielfeld();
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,UIConstants.appwidth, UIConstants.appheight);
        initLayout(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    public static void main(String[] args) {
        launch(args);
    }
    private void initLayout (BorderPane root) {
        initInfoCenter(root);
        initTileBoard(root);
    }

    private void initTileBoard(BorderPane root) {
        tileBoard = new TileBoard(infoCenter, spielfeld);
        root.getChildren().add(tileBoard.getStackPane());
    }

    private void initInfoCenter(BorderPane root) {
        infoCenter = new InfoCenter();
        infoCenter.setStartGameButtonOnAktion(startNewGame());
        root.getChildren().add(infoCenter.getPane());
    }
    private EventHandler<ActionEvent> startNewGame() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                    ;

            }
        };
    }

}


