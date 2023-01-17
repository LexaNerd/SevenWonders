package com.example.sevenwonders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController {

    @FXML
    private Slider sliderplayernumber;

    @FXML
    private Text labelplayer;

    @FXML
    private TextField playername;

    @FXML
    private ChoiceBox<String> selectwonderone;
    private String[] wonders = {"Alexandrie","Babylone","Ephese","Gizeh","Halicarnasse","Olympie","Rhodes"};

    /*@FXML
    void importwonders(MouseEvent event) {

        selectwonderone.getItems().addAll(wonders);

    }*/

    public static int nbjoueurs;

    /*@FXML
    public void initialize() {
        Game.option.startNewGame();
    }*/


    @FXML
    void onnextaction(ActionEvent event) {

        //labelplayer.setText(selectwonderone.getValue());
        System.out.println(selectwonderone.getValue());
        System.out.println(playername.getText());

    }


    public void startgame(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("numberplayer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);
            stage.setTitle("selectnumberplayer");
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void numberchose(ActionEvent event) throws IOException {

        nbjoueurs = (int) sliderplayernumber.getValue();
        System.out.println(nbjoueurs);

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("decidewonder.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);
            stage.setTitle("selectwonder");
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    public void importwonders(javafx.scene.input.MouseEvent mouseEvent) {

        selectwonderone.getItems().setAll(wonders);

    }


    /*public void initialize(URL url, ResourceBundle resourceBundle) {

        selectwonderone.getItems().addAll(wonders);

    }*/
}