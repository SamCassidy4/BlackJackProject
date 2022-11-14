package com.skilldistillery.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.BlackJackHand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();

	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		Deck main = new Deck();

		Dealer dealer = new Dealer();
		BlackJackHand player = new BlackJackHand();
		main.shuffle();

		player.getHand(main);
		dealer.getHand().addCard(dealer.dealCard());

		if (player.isBlackJack()) {
			System.out.println("You got a Black Jack... you WIN!");
			run();
		} else if (dealer.getHand().isBlackJack()) {
			System.out.println("Dealer has a Black Jack. You lose");
			run();
		}

		while (true) {
			System.out.println("Your cards are: " + player.toString());
			System.out.println();
			System.out.println("The Dealer's card is: " + dealer.hiddenCardToString());

			System.out.println("Would you like to hit or stand");
			System.out.println();
			System.out.println("1. Hit  2. Stand");

			int userInput = sc.nextInt();

			if (userInput == 1) {
				Card dealtCard = main.dealCard();
				System.out.println("You chose to hit " + dealtCard.toString());
				player.addCard(dealtCard);

				if (player.isBust()) {
					System.out.println("Bust, dealer wins");
					break;
				} else {
					continue;
				}
			}

			while (dealer.hitOrStand()) {
				Card dealtCard = main.dealCard();
				dealer.getHand().addCard(dealtCard);
				System.out.println(dealtCard.toString());

				if (dealer.getHand().isBust()) {
					System.out.println(dealer.getHand().toString() + "Dealer, bust, you win");
					break;
				} else {
					continue;
				}
			}

			if (dealer.getHand().isBust() || player.isBust()) {
				player.clearHand();
				player.getHand(main);
				dealer.getHand().clearHand();
				dealer.getHand().getHand(main);
				break;
			}

			System.out.println(
					"Dealers cards: " + dealer.getHand().toString() + "Value: " + dealer.getHand().getHandValue());
			if (player.getHandValue() > dealer.getHand().getHandValue()) {
				System.out.println("You win!");
				player.clearHand();
				player.getHand(main);
				dealer.getHand().clearHand();
				dealer.getHand().getHand(main);
				continue;
			}

			else if (player.getHandValue() < dealer.getHand().getHandValue()) {
				System.out.println("Dealer Wins");
				player.clearHand();
				player.getHand(main);
				dealer.getHand().clearHand();
				dealer.getHand().getHand(main);
				continue;
			} else {
				System.out.println("Draw");
				player.clearHand();
				player.getHand(main);
				dealer.getHand().clearHand();
				dealer.getHand().getHand(main);
				continue;
			}
		}
		sc.close();
	}
}
