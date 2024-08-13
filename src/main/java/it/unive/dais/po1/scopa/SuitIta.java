package it.unive.dais.po1.scopa;

import it.unive.dais.po1.Suit;

public class SuitIta extends Suit {
    public static SuitIta bastoni = new SuitIta("bastoni");
    public static SuitIta coppe = new SuitIta("coppe");
    public static SuitIta danari = new SuitIta("danari");
    public static SuitIta spade = new SuitIta("spade");


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
}
