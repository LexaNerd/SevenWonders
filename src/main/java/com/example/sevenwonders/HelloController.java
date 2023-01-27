package com.example.sevenwonders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HelloController implements Initializable{

    @FXML private Button nextCardButton;
    @FXML private ImageView deckimageView;
    @FXML private ImageView activeCardimageView;
    private DeckOfCards deck;
    private Card cards;

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


        /* initialisation du deck de carte et attribution d'une image pour le dos des cartes de la pioche sur l'interface*/

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            deck = new DeckOfCards();
            //System.out.println(deck.getDeck().get(0).getColor()+" " + deck.getDeck().get(0).getFaceName());
            //deckimageView.setImage(deck.getBackOfCardImage());
        }

    @FXML
    public void nextCardButtonPushed()
    {
        System.out.println(deck.getDeck().get(0).getColor()+" " + deck.getDeck().get(0).getFaceName());
        deck.dealTopCard();
        Card card = new Card(deck.getDeck().get(0).getFaceName(),deck.getDeck().get(0).getColor());
        activeCardimageView.setImage(card.getImage());
    }

    /*
    onnextaction est le bouton de la page du choix de merveille qui va enregistrer le nom du joueur et sa merveille,
    la fonction va aussi stocker la liste des joueurs et va permettre de charger la scène du plateau à la fin.
    Il va aussi vider le textfield et le choix de la merveille entre deux sélections de joueurs
     */
    @FXML
    void onnextaction(ActionEvent event) throws IOException {
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
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("plateau.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            stage.setTitle("plateaudejeu");
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
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
            playername.setText("");
            selectwonderone.setValue(null);
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