package it.unive.dais.po1.italianCardsGames;

import it.unive.dais.po1.Card;

public class ItalianCardsGame {

    protected Card<SuitIta> getCardFromString(String card){
        String[] valueSuit = card.split("-");
        int value = Integer.parseInt(valueSuit[0]);
        SuitIta suit;
        switch (valueSuit[1]){
            case "bastoni" -> suit = SuitIta.BASTONI;
            case "coppe" -> suit = SuitIta.COPPE;
            case "danari" -> suit = SuitIta.DANARI;
            case "spade" -> suit = SuitIta.SPADE;
            default -> throw new RuntimeException();
        };
        return new Card<>(value, suit);
    }

    protected boolean isCardValid(String card){
        return card.matches("^([1-9]|10)-(bastoni|coppe|danari|spade)$");
    }
}
