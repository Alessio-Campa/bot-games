package it.unive.dais.po1;

import it.unive.dais.po1.scopa.SuitIta;

public class Player<S extends Suit>{
    private final String name;
    private final Hand<S> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand<>();
    }

    public String getName() {
        return name;
    }

    public Hand<S> getHand() {
        return hand;
    }

    public Card<S> playCard(int i) {
        return this.hand.getCards().get(i);
    }

}
