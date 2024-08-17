package it.unive.dais.po1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck<S extends Suit> {
    private List<Card<S>> deck;
    private int position = 0;

    public Deck(int cardsPerSuit, Collection<S> semi){
        deck = new ArrayList<>();
        for(int i = 0; i < cardsPerSuit; i++){
            for(S seme: semi){
                deck.add(new Card<>(i+1, seme));
            }
        }
        Collections.shuffle(deck);
    }

    public Card<S> pickTopCard(){
        return this.deck.get(this.position++);
    }

    public Collection<Card<S>> pickTopNCards(int n){
        Collection<Card<S>> cards = new ArrayList<>();
        for(int i = 0; i < n; i++){
            cards.add(this.pickTopCard());
        }
        return cards;
    }

    public boolean isEmpty(){
        return position >= 40;
    }

}
