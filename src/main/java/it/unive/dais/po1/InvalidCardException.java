package it.unive.dais.po1;

public class InvalidCardException extends RuntimeException{
    public InvalidCardException(){
        super("The input is formatted incorrectly, expecting 'value-suit'");
    }
    public InvalidCardException(String got){
        super("The input is formatted incorrectly: expecting 'value-suit', got " + got);
    }
}
