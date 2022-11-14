package com.skilldistillery.cardgame;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackJackHand extends Hand {

	public BlackJackHand() {
	}

	public void getHand(Deck deck) {
		for (int i = 0; i < 2; i++) {
			addCard(deck.dealCard());
		}
	}

	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue(card);

		}
		return value;

	}

	public boolean isBlackJack() {
		if (getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}
}
