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
import java.util.ArrayList;
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
    public ArrayList<Playerz> playerList = new ArrayList<Playerz>();

    /*@FXML
    void importwonders(MouseEvent event) {

        selectwonderone.getItems().addAll(wonders);

    }*/

    public static int nbjoueurs;

    /*@FXML
    public void initialize() {
        Game.option.startNewGame();
    }*/

    /*
    onnextaction est le bouton de la page du choix de merveille qui va enregistrer le nom du joueur et sa merveille,
    la fonction va aussi stocker la liste des joueurs et va permettre de charger la scène du plateau à la fin.
     */
    @FXML
    void onnextaction(ActionEvent event) {
        if(nbjoueurs==1){
            Wonder wonder = null;
            switch(selectwonderone.getValue()){
                case "Alexandrie":
                    wonder = Wonder.Alexandrie;
                case "Babylone":
                    wonder = Wonder.Babylone;
                case "Ephese":
                    wonder = Wonder.Ephese;
                case "Gizeh":
                    wonder = Wonder.Gizeh;
                case "Halicarnasse":
                    wonder = Wonder.Halicarnasse;
                case "Olympie":
                    wonder = Wonder.Olympie;
                case "Rhodes":
                    wonder = Wonder.Rhodes;
            }
            Playerz playerz = new Playerz(playername.getText(),wonder);
            playerList.add(playerz);
            System.out.println(selectwonderone.getValue());
            System.out.println(playername.getText());
            nbjoueurs--;
            System.out.println(nbjoueurs);
            System.out.println(playerList);
            //load scene
        }else{
            Wonder wonder = null;
            switch(selectwonderone.getValue()){
                case "Alexandrie":
                    wonder = Wonder.Alexandrie;
                case "Babylone":
                    wonder = Wonder.Babylone;
                case "Ephese":
                    wonder = Wonder.Ephese;
                case "Gizeh":
                    wonder = Wonder.Gizeh;
                case "Halicarnasse":
                    wonder = Wonder.Halicarnasse;
                case "Olympie":
                    wonder = Wonder.Olympie;
                case "Rhodes":
                    wonder = Wonder.Rhodes;
            }
            Playerz playerz = new Playerz(playername.getText(),wonder);
            playerList.add(playerz);
            System.out.println(selectwonderone.getValue());
            System.out.println(playername.getText());
            nbjoueurs--;
            System.out.println(nbjoueurs);
            System.out.println(playerList);
        }

    }

    /*
    fonction startgame permet de passer à la page de choix du nombre de joueurs
     */
    public void startgame(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("numberplayer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("selectnumberplayer");
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    La fonction numberchose permet de charger la page pour choisir son nom et sa merveille, elle
    permet aussi de prendre en compte le nombre de joueur et de stocker cette variable.
     */
    public void numberchose(ActionEvent event) throws IOException {

        nbjoueurs = (int) sliderplayernumber.getValue();
        System.out.println(nbjoueurs);

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("decidewonder.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("selectwonder");
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    /*
    enregistre les wonders
     */
    public void importwonders(javafx.scene.input.MouseEvent mouseEvent) {

        selectwonderone.getItems().setAll(wonders);

    }


    /*public void initialize(URL url, ResourceBundle resourceBundle) {

        selectwonderone.getItems().addAll(wonders);

    }*/
}