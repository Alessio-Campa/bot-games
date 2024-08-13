package it.unive.dais.po1.scopa;

import it.unive.dais.po1.Deck;
import it.unive.dais.po1.Hand;
import it.unive.dais.po1.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Scopa {
    private Deck<SuitIta> deck;
    private Player<SuitIta> player1, player2;
    private ScopaTable table;

    public Scopa(String player1, String player2) {
        this.player1 = new Player<>(player1);
        this.player2 = new Player<>(player2);
        this.table = new ScopaTable();

        this.deck = new Deck<>(10, List.of(SuitIta.bastoni, SuitIta.coppe, SuitIta.danari, SuitIta.spade));
        for(int i = 0; i < 3; i++){
            this.player1.getHand().addCard(this.deck.pickTopCard());
            this.player2.getHand().addCard(this.deck.pickTopCard());
        }
        this.table.addCards(this.deck.pickTopNCards(4));

        this.player1.getHand().print();
        this.player2.getHand().print();
        table.print();

        Scanner scanner = new Scanner(System.in);
        int card = scanner.nextInt();
        System.out.println(this.table.placeCard(this.player1.playCard(card)));

        table.print();

        card = scanner.nextInt();
        System.out.println(this.table.placeCard(this.player2.playCard(card)));

        table.print();
    }
}
