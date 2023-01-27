package com.example.sevenwonders;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DeckViewController implements Initializable {

    @FXML private Button nextCardButton;
    @FXML private ImageView deckimageView;
    @FXML private ImageView activeCardimageView;
    private DeckOfCards deck;

    /* initialisation du deck de carte et attribution d'une image pour le dos des cartes de la pioche sur l'interface*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deck = new DeckOfCards();

        deckimageView.setImage(deck.getBackOfCardImage());
    }

    /* Attribution d'une image pour la face des cartes tirées sur l'interface*/

    @FXML
    public void nextCardButtonPushed()
    {
        activeCardimageView.setImage(deck.dealTopCard().getImage());
    }

}
