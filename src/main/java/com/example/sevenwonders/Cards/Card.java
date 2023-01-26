package com.example.sevenwonders.Cards;


//import lombok.Data;

//@Data

public class Card {

    public final CardType front;
    public final CardBack back;

    /*pp*/ Card(CardType front, CardBack back) {
        this.front = front;
        this.back = back;
    }


}
