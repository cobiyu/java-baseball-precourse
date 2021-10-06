package baseball.services;

import baseball.domains.BaseballNumber;
import baseball.domains.NumberCompareResultType;
import baseball.domains.ResultState;

/**
 * @author cobiyu
 */
public class Referee {
	/**
	 * 입력숫자, 정답 비교
	 *
	 * @param playNumber 게임 숫자
	 * @param answerNumber 정답
	 * @return 비교 결과
	 */
	public static ResultState checkAnswerNumberAndPlayNumber(BaseballNumber playNumber, BaseballNumber answerNumber) {
		ResultState resultState = new ResultState();

		for (int i = 0; i < answerNumber.length(); i++) {
			char current = playNumber.getStringNumber().charAt(i);
			resultState.addNumberCompareResultType(getNumberCompareResultTypeBy(answerNumber, current, i));
		}

		return resultState;
	}

	/**
	 * 숫자별 검증
	 *
	 * @param answerNumber 정답
	 * @param checkSingleNumberChar 입력숫자의 checkIndex번째 문자
	 * @param checkIndex checkSingleNumberChar의 입력숫자 index
	 * @return 비교 결과 NumberCompareResultType
	 */
	private static NumberCompareResultType getNumberCompareResultTypeBy(
		BaseballNumber answerNumber,
		char checkSingleNumberChar,
		int checkIndex
	) {
		if (answerNumber.charAt(checkIndex) == checkSingleNumberChar) {
			return NumberCompareResultType.STRIKE;
		}

		if (answerNumber.contains(String.valueOf((checkSingleNumberChar)))) {
			return NumberCompareResultType.BALL;
		}

		return NumberCompareResultType.NOTHING;
	}
}
