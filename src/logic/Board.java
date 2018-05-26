package logic;

import model.Card;
import model.GameCard;

public class Board {

	private GameCard[][] board; 
	private int cardsLeft; 
	private static final int NUM_ROWS = 4; 
	private static final int NUM_COLS = 13; 

	public Board() {
		board = new GameCard[NUM_ROWS][NUM_COLS];
		cardsLeft = NUM_ROWS * NUM_COLS;
		Deck deck = new Deck();
		Card selected = null;
		deck.shuffle();
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				selected = deck.deal();
				board[i][j] = new GameCard(selected.getFaceIndex(selected.getFace()), selected.getSuitsIndex(selected.getSuit()), false);
			}
		}
	}

	public GameCard getCard(int row, int col) {
		if (invalidBoardPosition(row, col))
			return null;
		else
			return board[row][col];
	}

	public boolean removeCard(int row, int col) {

		if (invalidBoardPosition(row, col) || board[row][col] == null)
			return false;
		board[row][col] = null;
		cardsLeft--;
		return true;
	}
	

	public boolean removeCard(GameCard card) {
		for (int i = 0; i < NUM_ROWS; i++)
			for (int j = 0; j < NUM_COLS; j++)
				if (board[i][j] == card) {
					board[i][j] = null;
					cardsLeft--;
					return true;
				}

		return false;
	}

	public boolean isEmpty() {
		return cardsLeft == 0;
	}

	public boolean invalidBoardPosition(int row, int col) {
		return (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] == null);
	}

	public GameCard[][] getBoard() {
		return board;
	}

	public void setBoard(GameCard[][] board) {
		this.board = board;
	}	
	
}
