package it.unive.dais.po1.scopa;

import it.unive.dais.po1.Card;

import java.util.*;
import java.util.stream.Stream;

public class ScopaTable {
    List<Card<SuitIta>> cards;

    public ScopaTable() {
        this.cards = new ArrayList<>();
    }

    public ScopaTable(Collection<Card<SuitIta>> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public void addCard(Card<SuitIta> card) {
        this.cards.add(card);
    }

    public void addCards(Collection<Card<SuitIta>> cards) {
        this.cards.addAll(cards);
    }

    private void removeCards(Collection<Card<SuitIta>> cards){
        for (Card<SuitIta> c: cards){
            this.cards.remove(c);
        }
    }

    public Collection<Collection<Card<SuitIta>>> placeCard(Card<SuitIta> card) {
        List<Collection<Card<SuitIta>>> matches = findMatches(card.getValue(), 0);
        if (matches.isEmpty()){
            this.cards.add(card);
        }
        else if (matches.size() == 1) {
            this.removeCards(matches.get(0));
        }
        else {
            Scanner scanner = new Scanner(System.in);
            int selected;
            System.out.println(matches);
            do{
                selected = scanner.nextInt();
            }while (selected >= matches.size());
            this.removeCards(matches.get(selected));
        }
        return matches;
    }

    private List<Collection<Card<SuitIta>>> findMatches(int target, int pos) {
        if (pos == this.cards.size() || target <= 0) return List.of();

        List<Collection<Card<SuitIta>>> without = findMatches(target, pos + 1);
        List<Collection<Card<SuitIta>>> with;
        if (target == this.cards.get(pos).getValue()) {
            with = List.of(new ArrayList<>(List.of(this.cards.get(pos))));
        }else {
            with = findMatches(target - this.cards.get(pos).getValue(), pos + 1);
            for (Collection<Card<SuitIta>> c : with) {
                c.add(this.cards.get(pos));
            }
        }
        return Stream.concat(with.stream(), without.stream()).toList();
    }

    public void print(){
        System.out.println(cards);
    }

}
