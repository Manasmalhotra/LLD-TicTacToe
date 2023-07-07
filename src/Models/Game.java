package Models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exceptions.InvalidGameException;
import strategies.GameWinnerStrategy;
import strategies.OrderOneWinnerStrategy;

public class Game {
Board board;
List<Player>players;
List<Move>moves;
GameStatus state;
GameWinnerStrategy strategy;
int nextPlayerIndex;
Player winner;

private Game() {
	
}

public Board getBoard() {
	return board;
}

public void setBoard(Board board) {
	this.board = board;
}

public List<Player> getPlayers() {
	return players;
}

public void setPlayers(List<Player> players) {
	this.players = players;
}

public List<Move> getMoves() {
	return moves;
}

public void setMoves(List<Move> moves) {
	this.moves = moves;
}

public GameStatus getState() {
	return state;
}

public void setState(GameStatus state) {
	this.state = state;
}

public GameWinnerStrategy getStrategy() {
	return strategy;
}

public void setStrategy(GameWinnerStrategy strategy) {
	this.strategy = strategy;
}

public int getNextPlayerIndex() {
	return nextPlayerIndex;
}

public void setNextPlayerIndex(int nextPlayerIndex) {
	this.nextPlayerIndex = nextPlayerIndex;
}

public Player getWinner() {
	return winner;
}

public void setWinner(Player winner) {
	this.winner = winner;
}


public static Builder getBuilder() {
	return new Builder();
}

public static class Builder{
    int dimension;
    List<Player>players;
    
	public int getDimension() {
		return dimension;
	}
	public Builder setDimension(int dimension) {
		this.dimension = dimension;
		return this;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public Builder setPlayers(List<Player> players) {
		this.players = players;
		return this;
	}
	public boolean isValid() {
		if(dimension<3) {
			return false;
		}
		return true;
	}
	public Game build() throws InvalidGameException{
		if(!isValid()) {
			throw new InvalidGameException("Some invalid input.Please try again!");
		}
		Game Game =new Game();
		Game.setPlayers(players);
		Game.setBoard(new Board(dimension));
		Game.setNextPlayerIndex(0);
		Game.setStrategy(new OrderOneWinnerStrategy(dimension));
		Game.setState(GameStatus.IN_PROGRESS);
		Game.setMoves(new ArrayList<>());
		return Game;
	}
    
}

public void displayBoard() {
	board.display();
	
}

public void makeNextMove() {
	Player playerToMove=players.get(nextPlayerIndex);
	Move move=null;
	Cell c=null;
	int row;
	int col;
	while(true) {
	try {
	move=playerToMove.decideMove(board);
	}
	catch(InputMismatchException e) {
		System.out.println("Do you want to quit the game? Enter y/n.");
		Scanner sc=new Scanner(System.in);
		String quitDecision=sc.next();
		if(quitDecision=="n") {
			System.out.println("Please enter your move again");
		}
		else {
			state=GameStatus.ENDED;
			return;
		}
		
	}
	c=move.getCell();
	row=c.getRow();
	col=c.getCol();
	if(board.isValidMove(row,col)) {
		break;
	}
	else {
		System.out.println("Invalid Move.. Please enter a valid move");
	 }
   }
	c.setPlayer(playerToMove);
    board.getBoard().get(row).get(col).setPlayer(playerToMove);
    board.getBoard().get(row).get(col).setState(CellState.FILLED);
	moves.add(move);
	if(strategy.checkWinner(board,playerToMove,c)) {
		state = GameStatus.ENDED;
        winner = playerToMove;
	}
	nextPlayerIndex = (nextPlayerIndex+1) % players.size();
}

public void undo() {
if(moves.size()==0) {
	System.out.println("No moves to undo.. Please continue playing the game.");
	return;
}
Move move=moves.get(moves.size()-1);
moves.remove(moves.size()-1);
int row=move.getCell().getRow();
int col=move.getCell().getCol();
board.getBoard().get(row).get(col).setState(CellState.EMPTY);
nextPlayerIndex=(nextPlayerIndex-1)%players.size();	
}

public boolean completelyFilledBoard() {
	return board.completelyFilled();
}

}
