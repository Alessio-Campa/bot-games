package it.unive.dais.po1.scopa;

import it.unive.dais.po1.Card;
import it.unive.dais.po1.Hand;
import it.unive.dais.po1.Player;

public class ScopaPlayer extends Player<SuitIta> {
    private final Hand<SuitIta> pile;

    public ScopaPlayer(String name) {
        super(name);
        this.pile = new Hand<>();
    }

    public Hand<SuitIta> getPile() {
        return pile;
    }

    public void placeCard(Card<SuitIta> card){

    }
}
