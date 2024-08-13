package it.unive.dais.po1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hand<S extends Suit> {
    private List<Card<S>> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public Hand(List<Card<S>> cards){
        this();
        this.cards.addAll(cards);
    }

    public boolean isEmpty(){
        return this.cards.isEmpty();
    }

    public void addCard(Card<S> card){
        this.cards.add(card);
    }
    public void addCards(Collection<Card<S>> cards){
        this.cards.addAll(cards);
    }

    public void print(){
        System.out.println(cards);
    }

    public Card<S> removeCard(Card<S> card){
        for(Card<S> c: this.cards){
            if (c.equals(card)) return c;
        }
        return null;
    }

    public List<Card<S>> getCards() {
        return cards;
    }
}
