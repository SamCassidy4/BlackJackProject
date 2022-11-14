package com.skilldistillery.cards;

import java.util.Objects;

public class Card {
	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		// I need to remember to slow down
		// a card or a smaller object making up a larger story
		// is made up of different things. Like a rank, and a suit for a card
		// or a name and a number for ping pong balls

	}

	public String toString() {
		return rank.getValue() + " of " + suit + " ";
	}

	public int getValue(Card card) {
		return card.rank.getValue();
		// I would like to get the RANK of a card or the value
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

}
