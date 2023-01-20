package com.example.sevenwonders;

public class Playerz {

    private String name;
    private Wonder wonder;

    public Playerz(String name, Wonder wonder){
        this.name = name;
        this.wonder = wonder;

    }

    public String getName(){
        return this.name;
    }
    public Wonder getWonder() {return this.wonder;}

}
