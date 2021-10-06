package baseball;

import baseball.domains.ResultState;
import nextstep.utils.Console;

/**
 * @author cobiyu
 */
public class ConsoleView {
	public static final String CONTINUE = "1";
	public static final String GAME_OVER = "2";

	/**
	 * 숫자 입력
	 * @return 입력한 숫자
	 */
	public static String printInputNumber() {
		System.out.print("숫자를 입력해주세요 : ");

		return Console.readLine();
	}

	/**
	 * 게임 결과 출력
	 */
	public static void printResult(ResultState resultState) {
		System.out.println(resultState.getStateMessage());
	}

	/**
	 * 게임 끝 메시지 출력
	 */
	public static void printSuccessMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	/**
	 * 새 게임 입력
	 */
	public static boolean isContinueReGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String inputStr = Console.readLine();

		if (inputStr.equals(CONTINUE)) {
			return true;
		}
		if (inputStr.equals(GAME_OVER)) {
			return false;
		}

		return isContinueReGame();
	}

}
