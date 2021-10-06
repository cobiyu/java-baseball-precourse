package baseball.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultStateTest {
	@DisplayName("3스트라이크 Result")
	@Test
	public void successTest() {
		//given
		ResultState resultState = new ResultState();

		// when
		resultState.addNumberCompareResultType(NumberCompareResultType.STRIKE);
		resultState.addNumberCompareResultType(NumberCompareResultType.STRIKE);
		resultState.addNumberCompareResultType(NumberCompareResultType.STRIKE);

		// then
		assertEquals(resultState.toGameResultType(), GameResultType.SUCCESS);
		assertEquals(resultState.getStateMessage(), "3스트라이크");
	}

	@DisplayName("3볼 Result")
	@Test
	public void threeBallTest() {
		//given
		ResultState resultState = new ResultState();

		// when
		resultState.addNumberCompareResultType(NumberCompareResultType.BALL);
		resultState.addNumberCompareResultType(NumberCompareResultType.BALL);
		resultState.addNumberCompareResultType(NumberCompareResultType.BALL);

		// then
		assertEquals(resultState.toGameResultType(), GameResultType.FAIL);
		assertEquals(resultState.getStateMessage(), "3볼");
	}

	@DisplayName("1스트라이크 2볼 Result")
	@Test
	public void oneStrikeTwoBallTest() {
		//given
		ResultState resultState = new ResultState();

		// when
		resultState.addNumberCompareResultType(NumberCompareResultType.BALL);
		resultState.addNumberCompareResultType(NumberCompareResultType.STRIKE);
		resultState.addNumberCompareResultType(NumberCompareResultType.BALL);

		// then
		assertEquals(resultState.toGameResultType(), GameResultType.FAIL);
		assertEquals(resultState.getStateMessage(), "1스트라이크 2볼");
	}

	@DisplayName("1볼 Result")
	@Test
	public void oneBallTest() {
		//given
		ResultState resultState = new ResultState();

		// when
		resultState.addNumberCompareResultType(NumberCompareResultType.NOTHING);
		resultState.addNumberCompareResultType(NumberCompareResultType.NOTHING);
		resultState.addNumberCompareResultType(NumberCompareResultType.BALL);

		// then
		assertEquals(resultState.toGameResultType(), GameResultType.FAIL);
		assertEquals(resultState.getStateMessage(), "1볼");
	}

	@DisplayName("2스트라이크 Result")
	@Test
	public void twoStrikeTest() {
		//given
		ResultState resultState = new ResultState();

		// when
		resultState.addNumberCompareResultType(NumberCompareResultType.STRIKE);
		resultState.addNumberCompareResultType(NumberCompareResultType.NOTHING);
		resultState.addNumberCompareResultType(NumberCompareResultType.STRIKE);

		// then
		assertEquals(resultState.toGameResultType(), GameResultType.FAIL);
		assertEquals(resultState.getStateMessage(), "2스트라이크");
	}

	@DisplayName("낫싱 Result")
	@Test
	public void nothingTest() {
		// given
		ResultState resultState = new ResultState();

		// when
		resultState.addNumberCompareResultType(NumberCompareResultType.NOTHING);

		// then
		assertEquals(resultState.toGameResultType(), GameResultType.FAIL);
		assertEquals(resultState.getStateMessage(), "낫싱");
	}
}
