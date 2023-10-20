package ole.praktikum.ui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;


public class InfoCenter {


    private StackPane pane;
    private Label massage;
    private Button startGameButton;

    public InfoCenter()
    {
        pane = new StackPane();
        //pane.setMinSize(UIConstants.appwidth,UIConstants.infocenterheight);

        massage = new Label("Tic-Tac-Toe");
        massage.setMinSize(UIConstants.appwidth,UIConstants.infocenterheight);
        massage.setFont(Font.font(24));
        massage.setAlignment(Pos.CENTER);
        massage.setTranslateY(-20);

        pane.getChildren().add(massage);

        startGameButton = new Button("Start New Game");
        startGameButton.setMinSize(135,30);
        startGameButton.setTranslateY(20);
        pane.getChildren().add(startGameButton);
    }

    public StackPane getPane() {
        return pane;
    }
    public void updateMessage(String newmessage) {
        massage.setText(newmessage);
    }
    public void showStartButton(){
        startGameButton.setVisible(true);
    }
    public void hideStartButton(){
        startGameButton.setVisible(false);
    }
    public void setStartGameButtonOnAktion(EventHandler<ActionEvent> onAktion){
        startGameButton.setOnAction(onAktion);
    }
}
