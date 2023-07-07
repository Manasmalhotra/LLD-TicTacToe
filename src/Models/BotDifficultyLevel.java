package Models;

public enum BotDifficultyLevel {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");
    
	private String name;
	BotDifficultyLevel(String level) {
		this.name=level;
	}
	public String getName() {
		return name;
	}
}
