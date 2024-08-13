package it.unive.dais.po1;

public abstract class Suit {
    private final String suit;

    public Suit(String suit){
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return this.getSuit();
    }
}
