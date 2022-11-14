package com.skilldistillery.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.BlackJackHand;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp2 {

	public static void main(String[] args) {
		BlackJackApp2 app = new BlackJackApp2();
		
		app.run();

	}
	public void run() {
		Scanner sc = new Scanner (System.in);
		Deck main = new Deck();
		
		main.shuffle();
		
		Dealer dealer = new Dealer();
		Player user = new Player();
		
		BlackJackHand player = new BlackJackHand();
		player.getHand(main);
		dealer.getHand().addCard(dealer.dealCard());
		
		if(player.isBlackJack()) {
			System.out.println("Congradulations! You win");
			run();
		}
		if(dealer.getHand().isBlackJack()) {
			System.out.println("Dealer wins");
			run();
		}
		
		
		
	}

}
