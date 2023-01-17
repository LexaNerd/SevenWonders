package com.example.sevenwonders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController {

    @FXML
    private Slider sliderplayernumber;

    @FXML
    private ChoiceBox<String> selectwonderone;
    private String[] wonders = {"Alexandrie","Babylone","Ephese","Gizeh","Halicarnasse","Olympie","Rhodes"};

    public static int nbjoueurs;

    @FXML
    public void initialize() {
        Game.option.startNewGame();
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

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("decidewonder.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);
            stage.setTitle("selectwonder");
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectwonderone.getItems().addAll(wonders);

    }
}