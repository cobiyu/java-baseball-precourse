package baseball.domains;

/**
 * @author cobiyu
 */
public class ResultState {
	private int strikeCount;
	private int ballCount;

	/**
	 * constructor
	 */
	public ResultState() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	/**
	 * strike, ball 결과 추가
	 */
	public void addNumberCompareResultType(NumberCompareResultType numberCompareResultType) {
		validation();

		if (numberCompareResultType.equals(NumberCompareResultType.STRIKE)) {
			strikeCount++;
		}

		if (numberCompareResultType.equals(NumberCompareResultType.BALL)) {
			ballCount++;
		}
	}

	/**
	 * strike, ball validation
	 */
	public void validation() {
		if (strikeCount >= BaseballNumber.NUMBER_MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid add result :: max strike");
		}
		if (ballCount >= BaseballNumber.NUMBER_MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid add result :: max ball");
		}
	}

	/**
	 * 게임 결과에 맞는 결과 종류 반환
	 */
	public GameResultType toGameResultType() {
		// 스트라이크가 게임 숫자보다 적으면 FAIL
		if (strikeCount < BaseballNumber.NUMBER_MAX_LENGTH) {
			return GameResultType.FAIL;
		}

		return GameResultType.SUCCESS;
	}

	/**
	 * 게임 결과에 맞는 메시지 반환
	 */
	public String getStateMessage() {
		if (strikeCount + ballCount <= 0) {
			return NumberCompareResultType.NOTHING.getName();
		}

		return getStrikeMessage() + getBallMessage();
	}

	/**
	 * 볼 count 관련 메시지
	 */
	private String getBallMessage() {
		String message = "";
		if (strikeCount > 0 && ballCount > 0) {
			message += " ";
		}

		if (ballCount > 0) {
			message += ballCount + "볼";
		}

		return message;
	}

	/**
	 * 스트라이크 count 관련 메시지
	 */
	private String getStrikeMessage() {
		if (strikeCount > 0) {
			return strikeCount + "스트라이크";
		}

		return "";
	}
}
