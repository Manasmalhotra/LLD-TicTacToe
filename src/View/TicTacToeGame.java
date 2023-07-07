package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Bot;
import Models.BotDifficultyLevel;
import Models.Game;
import Models.GameStatus;
import Models.Player;
import Models.PlayerType;
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
	   int playerCount=1;
	   if(botRequired.equals("y")) {
		   System.out.println("Please enter the name of the bot(Player 1)");
		   String name=sc.next();
		   System.out.println("Please enter the symbol of the bot");
		   char symbol=sc.next().charAt(0);
		   Bot bot=new Bot(name,symbol,BotDifficultyLevel.EASY);
		   Players.add(bot);
		   playerCount+=1;
	   }
	   
	   for(int i=1;i<=numberOfPlayers;i++) {
		   System.out.println("Please enter the name of Player "+playerCount);
		   String name=sc.next();
		   System.out.println("Please enter the symbol of the Player "+i);
		   char symbol=sc.next().charAt(0);
		   Player p=new Player(name,symbol,PlayerType.HUMAN);
		   Players.add(p);
		   playerCount++;
	   }
	   
	  
	   Game game=gameController.createGame(dimension,Players);
	   while(game.getState()==GameStatus.IN_PROGRESS) {
		     System.out.println("This is the current board");
		     gameController.displayboard(game);
		     System.out.println("This is player"+Integer.toString(gameController.getNextPlayer(game)+1)+"'s turn");
		     System.out.println("Do you want to undo ? y/n");
	            String input = sc.next();

	            if (input.equals("y")) {
	                gameController.undo(game);
	            } else {
	                gameController.executeNextMove(game);
	            }
	        }
	   
	        if (game.getState().equals(GameStatus.ENDED)) {
	            try {
	            System.out.println("The game has ended, Result is:");
	            System.out.println("Winner is : " + gameController.getWinner(game).getName());
	            }
	            catch(Exception e){
	                if(gameController.isDraw(game)) {
	                	System.out.println("The game ended in a draw!");
	                }
	                else {
	                	System.out.println("You have quit the game successfully thanks for playing!");
	                }
	            }
	        }
	   }
	   
   }
