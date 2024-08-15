package it.unive.dais.po1;

import it.unive.dais.po1.italianCardsGames.scopa.Scopa;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scopa game = new Scopa("AAAA", "BBBB");
        game.play();
    }
}