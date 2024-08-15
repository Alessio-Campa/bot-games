package it.unive.dais.po1.italianCardsGames.scopa;

import it.unive.dais.po1.Card;
import it.unive.dais.po1.Hand;
import it.unive.dais.po1.Player;
import it.unive.dais.po1.italianCardsGames.SuitIta;

import java.util.ArrayList;
import java.util.Collection;

public class ScopaPlayer extends Player<SuitIta> {
    private final Collection<Card<SuitIta>> pile;

    public ScopaPlayer(String name) {
        super(name);
        this.pile = new ArrayList<>();
    }

    public Collection<Card<SuitIta>> getPile() {
        return pile;
    }

    public Card<SuitIta> playCard(int i) {
        return this.getHand().removeCard(this.getHand().getCards().get(i));
    }

    public void removeCard(Card<SuitIta> card) {
        this.getHand().removeCard(card);
    }

    public boolean has (Card<SuitIta> card){
        return this.getHand().getCards().contains(card);
    }

    public void addToPile(Collection<Card<SuitIta>> cards){
        pile.addAll(cards);
    }
}
