package logic;

import java.util.Arrays;
import java.util.Collections;

import model.Card;

public class Deck {
	private static Card[] cards;
	private static final int DECK_SIZE = 52;
	private int cardsInDeck;
	
	public Deck()
	{
		cards = new Card[DECK_SIZE];
		cardsInDeck = DECK_SIZE;
		for (int i = 0; i < 13; i++) {
            cards[i] = new Card(i, 0);
            cards[i+13] = new Card(i, 1);
            cards[i+26] = new Card(i, 1);
            cards[i+39] = new Card(i, 1);
        }
	}
	
	public void shuffle()
	{
		Collections.shuffle(Arrays.asList(cards));
	}
	
	public Card deal() {
        if (cardsInDeck == 0)
        {    return null;	}

        cardsInDeck--;
        return cards[cardsInDeck];
	}
	
}
