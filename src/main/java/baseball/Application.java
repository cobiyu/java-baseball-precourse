package baseball;

import baseball.services.BaseballGame;

public class Application {
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.play();
	}
}
