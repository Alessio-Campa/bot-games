package it.unive.dais.po1.italianCardsGames;

import it.unive.dais.po1.Suit;

import java.util.Collection;
import java.util.List;

public class SuitIta extends Suit {
    public static final SuitIta BASTONI = new SuitIta("bastoni");
    public static final SuitIta COPPE = new SuitIta("coppe");
    public static final SuitIta DANARI = new SuitIta("danari");
    public static final SuitIta SPADE = new SuitIta("spade");


    private SuitIta(String suit){
        super(suit);
    }

    @Override
    public int hashCode() {
        return switch (this.getSuit()){
            case "bastoni" -> 0;
            case "coppe" -> 1;
            case "danari" -> 2;
            case "spade" -> 3;
            default -> -1;
        };
    }

    public static Collection<SuitIta> getSuits(){
        return List.of(BASTONI, COPPE, DANARI, SPADE);
    }
}
