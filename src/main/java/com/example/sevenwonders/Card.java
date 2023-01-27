package com.example.sevenwonders;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String faceName, color;
    private Image image;

    public Card(String faceName, String color) {
        setFaceName(faceName);
        setColor(color);
        String fileName = faceName + "_" + color +".png";
        image = new Image("images/card-back/"+fileName);
    }

    public String getFaceName() {
        return faceName;
    }

    public Image getImage() { return image; }

    public void setImage(Image image) {
        this.image = image;
    }

    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("brique","verre","piece","papier","pierre","bois","3pdv","2pdv","equerre","tablette",
                "engrenage","bouclier","bouclierSC","bouclierDC");
    }

    public void setFaceName(String faceName) {
            this.faceName = faceName;
    }

    public String getColor() {
        return color;
    }

    public static List<String> getValidColor()
    {
        return Arrays.asList("rouge","vert","bleu","jaune","gris");
    }

    public void setColor(String color) {
            this.color = color;
    }
    public String toString()
    {
        return String.format("%s of %s", faceName, color);
    }
}