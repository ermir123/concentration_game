package model;

import java.util.Arrays;

public class GameCard extends Card{
	
	private boolean faceUp;
	private boolean color;
	
	public GameCard(int face, int suit, boolean faceUp)
	{
		super(face,suit);
		this.faceUp = faceUp;
		color = (super.getSuit() == Card.SUITS[0] || super.getSuit() == Card.SUITS[2]);
	}
	
	public boolean getSuitColor() { 
        return color;
    }
	
	public boolean isFaceUp() { 
	        return faceUp;
	}
	 
	public void flip() { 
	    faceUp = !faceUp;
	}
	
	public boolean match(GameCard otherCard) {
        return (this.getFace() == otherCard.getFace() && 
                this.getSuitColor() == otherCard.getSuitColor());
    }
	
	public String toString()
	{
		return super.getFace()+" "+super.getSuit()+" "+getSuitColor();
	}

}
