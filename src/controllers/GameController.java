package controllers;

import java.util.List;

import Models.Player;
import exceptions.InvalidGameException;
import Models.BotDifficultyLevel;
import Models.Game;

public class GameController {

	public Game createGame(int dimension, List<Player> players) throws InvalidGameException {
		// TODO Auto-generated method stub
		return Game.getBuilder().setDimension(dimension).setPlayers(players).build();
	}

	public void displayboard(Game game) {
		game.displayBoard();
		
	}

	public void undo(Game game) {
		game.undo();
		
	}

	public void executeNextMove(Game game) {
		game.makeNextMove();
		
	}

	public Player getWinner(Game game) {
		// TODO Auto-generated method stub
		return game.getWinner();
	}

	public int getNextPlayer(Game game) {
		return game.getNextPlayerIndex();
	}

}
