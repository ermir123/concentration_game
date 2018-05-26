package model;

import java.util.Arrays;

public class Card {
	
	 public static final String[] SUITS = { "hearts", "spades", "diamonds", "clubs" };
	 public static final String[] FACE = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	 
	 private String face, suit;
	 
	 public Card(int face, int suit)
	 {
		 this.suit = SUITS[suit];
		 this.face = FACE[face];
	 }
	 
	 
	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
 
	public int getSuitsIndex(String suit)
	{
		for(int i = 0; i<SUITS.length; i++)
		{
			if(SUITS[i].equals(suit))
			{
				return i;
			}
		}
		return -1;
	}
	
	public int getFaceIndex(String face)
	{
		for(int i = 0; i<FACE.length; i++)
		{
			if(FACE[i].equals(face))
			{
				return i;
			}
		}
		return -1;
	}

}
