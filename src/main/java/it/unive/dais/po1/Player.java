package it.unive.dais.po1;

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

}
