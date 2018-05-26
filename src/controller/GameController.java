package controller;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import logic.Board;
import model.GameCard;

public class GameController {
	
	private static Scanner input;
	private static Board board;
	
	public static void main(String[] args)
	{	
		input = new Scanner(System.in);
		System.out.println("Emri lojtarit");
		String player = input.nextLine();
		System.out.println("Lojtari: "+player);
		
		board = new Board();
		GameCard[][] boards = board.getBoard();
		for(int i=0;i<boards.length; i++)
		{
			for (int j = 0; j < boards[i].length; j++)
			{
				System.out.print(boards[i][j].getFace() + " "+boards[i][j].getSuit()+ " | ");
			}
			System.out.println(" \n");
		}
		
		while(!board.isEmpty())
		{
			int v = play();
		}
	}
	
	
	public static int play() 
	{
		int points = 0;
		boolean matched = true;
        GameCard card1, card2;
        
		while(matched)
		{
			 card1 = selectCard();
	         card1.flip();
	         
	         card2 = selectCard();
             while (card1 == card2) {
                System.out.println("Nuk mund ta selekton te njejten kard dy here");
                card2 = selectCard();
             }
             card2.flip();
             System.out.println(card2.getSuit()+" "+card1.getSuit());
             
             if (card1.match(card2)) {
                 System.out.println("Match -- vazhdo perseri");
                 input.nextLine(); 
                 points++;
                 board.removeCard(card1);
                 board.removeCard(card2);
                 matched = true;
             }
             else {
                 System.out.println("Ska match -- kthehu prap");
                 input.nextLine(); 
                 card1.flip();
                 card2.flip();
                 matched = false;
             }
		}
		
		return points;
	}
	
	
	 private static GameCard selectCard() {
	        int row = 0, col = 0;
	        GameCard card = null;
	        boolean repeat = true;

	        if (board.isEmpty())
	            return null;
	        
	        while(repeat)
	        {
	        	System.out.print("Zgjedh karten: rreshti ");
	            row = Integer.parseInt(input.nextLine()) - 1;

	            System.out.print("          kolona ");
	            col = Integer.parseInt(input.nextLine()) - 1;

	            if (!board.invalidBoardPosition(row, col)) {
	                card = board.getCard(row, col);
	                repeat = false;
	            }
	            else {
	                System.out.println("Nuk ka rreshte dhe kolone te tille");
	            }
	        }

	        return card;
	    }

}
