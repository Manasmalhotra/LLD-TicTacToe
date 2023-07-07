package strategies;

import Models.Board;
import Models.Bot;
import Models.BotDifficultyLevel;
import Models.Move;

public interface BotPlayingStrategy {
	Move decideMove(Bot bot, Board board);
}
