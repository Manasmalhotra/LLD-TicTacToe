package strategies;

import Models.Board;
import Models.Cell;
import Models.Player;

public interface GameWinnerStrategy {
    boolean checkWinner(Board board,Player player,Cell cell);
}
