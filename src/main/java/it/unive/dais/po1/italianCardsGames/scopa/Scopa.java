package it.unive.dais.po1.italianCardsGames.scopa;

import it.unive.dais.po1.Card;
import it.unive.dais.po1.Deck;
import it.unive.dais.po1.Player;
import it.unive.dais.po1.italianCardsGames.ItalianCardsGame;
import it.unive.dais.po1.italianCardsGames.SuitIta;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Scopa extends ItalianCardsGame {
    private Deck<SuitIta> deck;
    private ScopaPlayer player1, player2;
    private ScopaTable table;
    private int turn = 0;
    private Scanner scanner = new Scanner(System.in);


    public Scopa(String player1, String player2) {
        this.player1 = new ScopaPlayer(player1);
        this.player2 = new ScopaPlayer(player2);
        this.table = new ScopaTable();

        this.deck = new Deck<>(10, List.of(SuitIta.BASTONI, SuitIta.COPPE, SuitIta.DANARI, SuitIta.SPADE));
        this.distributeCards();
        this.table.addCards(this.deck.pickTopNCards(4));
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        do {
            for (int i = 0; i < 3; i++) {
                System.out.println("Begin turn");
                System.out.print("Player 1 hand: ");
                this.player1.getHand().print();
                System.out.print("Player 2 hand: ");
                this.player2.getHand().print();
                table.print();

                playTurn();
                table.print();

                playTurn();
            }

            if (!deck.isEmpty()){
                distributeCards();
            }
        } while (!deck.isEmpty());
    }

    private void distributeCards(){
        for (int i = 0; i < 3; i++) {
            this.player1.getHand().addCard(this.deck.pickTopCard());
            this.player2.getHand().addCard(this.deck.pickTopCard());
        }
    }

    private void playTurn(){
        ScopaPlayer player = getTurnPlayer(this.turn);
        System.out.println("? Card");
        String input = scanner.nextLine();
        Card<SuitIta> card;
        if (!isCardValid(input)){
            throw new RuntimeException();
        }
        card = getCardFromString(input);
        if (!player.has(card)){
            throw new RuntimeException();
        }

        player.removeCard(card);
        Collection<Card<SuitIta>> gained = table.placeCard(card);
        player.addToPile(gained);

        turn = (turn+1)%2;
    }

    private ScopaPlayer getTurnPlayer(int turn){
        return turn == 0 ? player1 : player2;
    }
}
