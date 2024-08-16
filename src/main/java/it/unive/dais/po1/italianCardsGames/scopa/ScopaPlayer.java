package it.unive.dais.po1.italianCardsGames.scopa;

import it.unive.dais.po1.Card;
import it.unive.dais.po1.Player;
import it.unive.dais.po1.italianCardsGames.SuitIta;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class ScopaPlayer extends Player<SuitIta> {
    private final Collection<Card<SuitIta>> pile;
    private int points = 0;

    public ScopaPlayer(String name) {
        super(name);
        this.pile = new HashSet<>();
    }

    public Collection<Card<SuitIta>> getPile() {
        return pile;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int n) {
        this.points += n;
    }

    public Card<SuitIta> playCard(int i) {
        return this.getHand().removeCard(this.getHand().getCards().get(i));
    }

    public void removeCard(Card<SuitIta> card) {
        this.getHand().removeCard(card);
    }

    public boolean has(Card<SuitIta> card) {
        return this.getHand().getCards().contains(card);
    }

    public void addToPile(Collection<Card<SuitIta>> cards) {
        pile.addAll(cards);
    }

    public int getCardCount() {
        return pile.size();
    }

    public long getDanariCount() {
        return pile.stream().filter(card -> card.getSuit().equals(SuitIta.DANARI)).count();
    }

    public boolean hasSettebello() {
        return pile.contains(new Card<>(7, SuitIta.DANARI));
    }

    public boolean hasRebello() {
        return pile.contains(new Card<>(10, SuitIta.DANARI));
    }

    public int getPrimieraPoints() {
        int primiera = 0;
        for (SuitIta suit : SuitIta.getSuits()) {
            Optional<Integer> suitValue = pile
                    .stream()
                    .filter(card -> card.getSuit().equals(suit))
                    .map(card -> getPrimieraValue(card.getValue()))
                    .max(Integer::compare);
            if (suitValue.isEmpty()) return 0;
            primiera += suitValue.get();
        }
        return primiera;
    }

    private int getPrimieraValue(int value) {
        int[] map = {0, 16, 12, 13, 14, 15, 18, 21, 10, 10, 10};
        return map[value];
    }

    public void addNapoletanaPoints() {
        List<Integer> values = pile
                .stream()
                .filter(card -> card.getSuit().equals(SuitIta.DANARI))
                .map(Card::getValue)
                .toList();
        int i = 0;
        while (i + 1 == values.get(i)) {
            i++;
        }
        if (i >= 3) {
            this.addPoints(i);
        }
    }
}
