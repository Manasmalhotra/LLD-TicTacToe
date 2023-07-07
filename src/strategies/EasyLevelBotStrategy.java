package strategies;

import Models.Board;
import Models.Bot;
import Models.Cell;
import Models.CellState;
import Models.Move;

public class EasyLevelBotStrategy implements BotPlayingStrategy {

	@Override
	public Move decideMove(Bot bot, Board board) {
		 for (int i = 0; i < board.getBoard().size(); i++) {
	            for (int j = 0; j < board.getBoard().size(); j++) {
	                if (board.getBoard().get(i).get(j).getState().equals(CellState.EMPTY)) {
	                    return new Move(bot, new Cell(i, j));
	                }
	            }
	        }
	        return null;
	}	
}
