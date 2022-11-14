package com.skilldistillery.players;

import com.skilldistillery.cardgame.BlackJackHand;
import com.skilldistillery.cards.Deck;

public class Player {
	protected BlackJackHand hand = new BlackJackHand();

	public Player() {
		// I think having the dealer extend the player
		// class still inherits all of the objects
		// Player interaction will just occur in main
		// having methods that well encapsulate my hidden game data is good
		

	}

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

}
