package baseball.services;

import java.util.function.Supplier;

import baseball.ConsoleView;
import baseball.domains.BaseballNumber;
import baseball.domains.ResultState;
import baseball.exceptions.BaseballNumberValidationException;
import baseball.exceptions.ExceptionHandler;
import nextstep.utils.Randoms;

/**
 * @author cobiyu
 */
public class BaseballGame {
	/**
	 * 게임 시작
	 */
	public void play() {
		boolean isRetry = true;
		BaseballNumber answerNumber = generateAnswerBaseballNumber();

		while (isRetry) {
			isRetry = checkInputNumber(answerNumber);
		}

		reGameOrExit();
	}

	/**
	 * 게임 정답 생성
	 */
	private BaseballNumber generateAnswerBaseballNumber() {
		String answer = String.valueOf(Randoms.pickNumberInRange(1, 9));
		answer += String.valueOf(Randoms.pickNumberInRange(1, 9));
		answer += String.valueOf(Randoms.pickNumberInRange(1, 9));

		return new BaseballNumber(answer);
	}

	/**
	 * 사용자 입력 값 검증
	 */
	private boolean checkInputNumber(BaseballNumber answerNumber) {
		return runWithErrorHandling(() -> {
			BaseballNumber playNumber = new BaseballNumber(ConsoleView.printInputNumber());
			ResultState resultState = Referee.checkAnswerNumberAndPlayNumber(playNumber, answerNumber);

			ConsoleView.printResult(resultState);

			return resultState.toGameResultType().isRetry();
		});
	}

	/**
	 * validation을 포함한 Exception에 대한 처리
	 * - BaseballNumberValidationException일 경우 게임 재개
	 * - 이외의 Exception은 게임 중지
	 *   (모든 Exception을 대상으로 게임을 재개할 경우 ApplicationTest의 '낫싱' 테스트가 무한 루프에 빠짐)
	 */
	private boolean runWithErrorHandling(Supplier<Boolean> booleanLogic) {
		try {
			return booleanLogic.get();
		} catch (BaseballNumberValidationException ex) {
			ExceptionHandler.handling(ex);
			return true;
		} catch (Exception ex) {
			ExceptionHandler.handling(ex);
			return false;
		}
	}

	/**
	 * 게임 재시작
	 */
	private void reGameOrExit() {
		ConsoleView.printSuccessMessage();

		if (ConsoleView.isContinueReGame()) {
			play();
		}
	}
}
