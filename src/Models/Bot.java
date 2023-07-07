package Models;

import factories.BotStrategyFactory;
import strategies.BotPlayingStrategy;

public class Bot extends Player{
    BotDifficultyLevel level;
    BotPlayingStrategy strategy;
	public Bot(String name, char symbol,BotDifficultyLevel level) {
		super(name, symbol,PlayerType.BOT);
		this.level=level;
		this.strategy=BotStrategyFactory.getbotplayingStrategy(level);
		
	}
	public Move decideMove(Board board) {
		BotPlayingStrategy botStrategy= BotStrategyFactory.getbotplayingStrategy(level);
		return botStrategy.decideMove(this, board);
		
	}
}
