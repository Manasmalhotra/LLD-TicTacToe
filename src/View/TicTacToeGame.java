package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Bot;
import Models.BotDifficultyLevel;
import Models.Game;
import Models.GameStatus;
import Models.Player;
import controllers.GameController;
import exceptions.InvalidGameException;


public class TicTacToeGame {
   public static void main(String args[]) throws InvalidGameException{
	   GameController gameController=new GameController();
	   System.out.println("Hello, Welcome to Tic Tac Toe");
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Please enter the dimension of the game");
	   int dimension=sc.nextInt();
	   int numberOfPlayers=0;
	   int valid=0;
	   String botRequired = null;
	   
	   while(valid==0) {
	   System.out.println("Do you want a bot to play? Press y or n to indicate your choice.");
	   botRequired=sc.next();
	   if(botRequired.equals("y")) {
		  numberOfPlayers=dimension-2; 
		  valid=1;
	   }
	   else if(botRequired.equals("n")) {
		   numberOfPlayers=dimension-1;
		   valid=1;
	   }
	   else {
		   System.out.println("Invalid input please try again");
	   }
	   }
	   
	   List<Player>Players=new ArrayList<>();
	   for(int i=1;i<=numberOfPlayers;i++) {
		   System.out.println("Please enter the name of Player "+i);
		   String name=sc.next();
		   System.out.println("Please enter the symbol of the Player "+i);
		   char symbol=sc.next().charAt(0);
		   Player p=new Player(name,symbol);
		   Players.add(p);
	   }
	   if(botRequired.equals("y")) {
		   System.out.println("Please enter the name of the bot");
		   String name=sc.next();
		   System.out.println("Please enter the symbol of the bot");
		   char symbol=sc.next().charAt(0);
		   System.out.println("Please enter the level of the bot");
		   String level=sc.next();
		   BotDifficultyLevel l;
		   if(level.equalsIgnoreCase(BotDifficultyLevel.EASY.getName())) {
			   l=BotDifficultyLevel.EASY;
		   }
		   else if(level.equalsIgnoreCase(BotDifficultyLevel.MEDIUM.getName())) {
			   l=BotDifficultyLevel.MEDIUM;
		   }
		   else {
			   l=BotDifficultyLevel.HARD;
		   }
		   Bot bot=new Bot(name,symbol,l);
		   Players.add(bot);
	   }
	   
	  
	   Game game=gameController.createGame(dimension,Players);
	   while(game.getState()==GameStatus.IN_PROGRESS) {
		     System.out.println("This is the current board");
		     gameController.displayboard(game);
		     System.out.println("This is player"+Integer.toString(gameController.getNextPlayer(game))+"'s turn");
		     System.out.println("Do you want to undo ? y/n");
	            String input = sc.next();

	            if (input.equals("y")) {
	                gameController.undo(game);
	            } else {
	                gameController.executeNextMove(game);
	            }
	        }
	   
	        System.out.println("The game has ended, Result is:");
	        if (game.getState().equals(GameStatus.ENDED)) {
	            System.out.println("Winner is : " + gameController.getWinner(game).getName());
	        }
	   }
	   
   }
