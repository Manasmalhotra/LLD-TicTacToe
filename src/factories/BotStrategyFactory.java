package factories;

import Models.BotDifficultyLevel;
import strategies.BotPlayingStrategy;
import strategies.EasyLevelBotStrategy;
import strategies.HardLevelBotStrategy;
import strategies.MediumLevelBotStrategy;

public class BotStrategyFactory {

	public static BotPlayingStrategy getbotplayingStrategy(BotDifficultyLevel level) {
		if(level==BotDifficultyLevel.EASY) {
			return new EasyLevelBotStrategy();
		}
		else if(level==BotDifficultyLevel.MEDIUM) {
			return new MediumLevelBotStrategy();
		}
		else {
			return new HardLevelBotStrategy();
		}
	}
    
}
