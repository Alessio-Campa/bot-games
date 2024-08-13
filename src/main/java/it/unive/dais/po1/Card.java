package it.unive.dais.po1;

import java.util.Objects;

public class Card<S extends Suit> {
    private final Integer value;
    private final S suit;

    public Card(int value, S suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public S getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return this.value + "-" + this.suit.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card<?>)) return false;
        Card other = (Card) obj;
        return this.value.equals(other.value) && this.suit.equals(other.suit);
    }

    @Override
    public int hashCode() {
        return value + suit.hashCode();
    }
}
