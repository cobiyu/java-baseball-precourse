package baseball.domains;

/**
 * @author cobiyu
 *
 * 게임 결과 종류
 */
public enum GameResultType {
	SUCCESS(false),
	FAIL(true);

	boolean isRetry;

	GameResultType(boolean isRetry) {
		this.isRetry = isRetry;
	}

	public boolean isRetry() {
		return isRetry;
	}
}
