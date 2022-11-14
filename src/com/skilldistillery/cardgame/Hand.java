package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	
	List<Card> cards = new ArrayList<>();
	
	public Hand() {
		
	}
	
	public Card addCard(Card card) {
		cards.add(card);
		return card;
	}
	
	public void clearHand() {
		cards.removeAll(cards);
	}
	
	abstract public int getHandValue();
	
	public String toString() {
		String cardString = "";
		
		for (Card card : cards) {
			System.out.println(card);
			cardString += card.toString() + "";
			
		}
		return cardString;
		
	}
	

}
