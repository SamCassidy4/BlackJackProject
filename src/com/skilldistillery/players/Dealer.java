package com.skilldistillery.players;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player{
	Deck deck;
	
	
	public Dealer() {
		deck = new Deck();
		
	}
	
	public Card dealCard() {
		return deck.dealCard() ;
		
	}
	
	public boolean hitOrStand() {
		if(this.getHand().getHandValue() < 17) {
			System.out.println("The dealer hits");
			return true;
		} else {
			System.out.println("the dealer stands");
			return false;
		}
	}
	
		public String hiddenCardToString() {
			int i = 0;
			String [] secretCard = getHand().toString().split(" ");
			String secretCardString = "";
			for (String string : secretCard) {
				secretCardString += string + " ";
				if( i ==(secretCard.length - 4)) {
					break;
				}
				i++;
				
			}
			return secretCardString;
			
		}
	}


