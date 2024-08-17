package it.unive.dais.po1.italianCardsGames.scopa;

import it.unive.dais.po1.Card;
import it.unive.dais.po1.Deck;
import it.unive.dais.po1.InvalidCardException;
import it.unive.dais.po1.MissingCardException;
import it.unive.dais.po1.italianCardsGames.ItalianCardsGame;
import it.unive.dais.po1.italianCardsGames.SuitIta;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Scopa extends ItalianCardsGame {
    private Deck<SuitIta> deck;
    private ScopaPlayer player1, player2;
    private ScopaTable table;
    private int turn = 0;
    private Scanner scanner = new Scanner(System.in);

    private int lastPickup = 0;


    public Scopa(String player1, String player2) {
        this.player1 = new ScopaPlayer(player1);
        this.player2 = new ScopaPlayer(player2);
        this.table = new ScopaTable();

        this.deck = new Deck<>(10, List.of(SuitIta.BASTONI, SuitIta.COPPE, SuitIta.DANARI, SuitIta.SPADE));
        this.distributeCards();
        this.table.addCards(this.deck.pickTopNCards(4));
    }

    public void play() {
        while (player1.getPoints() < 21 && player2.getPoints() < 21){
            playMatch();
        }
    }

    private void playMatch(){
        do {
            if (player1.getHand().isEmpty() && player2.getHand().isEmpty()){
                distributeCards();
            }

            System.out.println("Begin turn");
            System.out.print("Player 1 hand: ");
            this.player1.getHand().print();
            System.out.print("Player 2 hand: ");
            this.player2.getHand().print();
            table.print();

            playTurn();
            table.print();

            playTurn();
        } while (!deck.isEmpty());
        if (lastPickup == 0){
            player1.addToPile(this.table.getCards());
        }else{
            player2.addToPile(this.table.getCards());
        }
        calcPoints();
        System.out.println(player1.getPoints() + " " +  player2.getPoints());
    }

    private void distributeCards() {
        for (int i = 0; i < 3; i++) {
            this.player1.getHand().addCard(this.deck.pickTopCard());
            this.player2.getHand().addCard(this.deck.pickTopCard());
        }
    }

    private void playTurn() {
        ScopaPlayer player = getTurnPlayer(this.turn);
        System.out.println("? Card");
        String input = scanner.nextLine();
        Card<SuitIta> card;
        if (!isCardValid(input)) {
            throw new InvalidCardException(input);
        }
        card = getCardFromString(input);
        if (!player.has(card)) {
            throw new MissingCardException();
        }

        player.removeCard(card);
        Collection<Card<SuitIta>> gained = table.placeCard(card);
        if (!gained.isEmpty()){
            player.addToPile(gained);
            lastPickup = turn;
        }
        if (table.isEmpty()){
            player.addPoints(1); // scopa
        }

        turn = (turn + 1) % 2;
    }

    private ScopaPlayer getTurnPlayer(int turn) {
        return turn == 0 ? player1 : player2;
    }

    private void calcPoints() {
        assignPoint(player1.getCardCount(), player2.getCardCount());
        assignPoint(player1.getDanariCount(), player2.getDanariCount());
        assignPoint(player1.hasSettebello(), player2.hasSettebello());
        assignPoint(player1.hasRebello(), player2.hasRebello());
        assignPoint(player1.getPrimieraPoints(), player2.getPrimieraPoints());
        player1.addNapoletanaPoints();
        player2.addNapoletanaPoints();
    }

    public ScopaPlayer getWinner(){
        if (player1.getPoints() == player2.getPoints()) return null;
        return player1.getPoints() > player2.getPoints() ? player1 : player2;
    }

    private void assignPoint(long value1, long value2) {
        if (value1 > value2) {
            player1.addPoints(1);
        } else if (value1 < value2) {
            player2.addPoints(1);
        }
    }

    private void assignPoint(boolean value1, boolean value2) {
        if (value1) {
            player1.addPoints(1);
        } else if (value2) {
            player2.addPoints(1);
        }
    }

}
