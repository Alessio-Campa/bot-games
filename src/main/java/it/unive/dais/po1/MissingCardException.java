package it.unive.dais.po1;

public class MissingCardException extends RuntimeException{
    public MissingCardException(){
        super("The card is formatted correctly but is not present in the player's hand");
    }
}
