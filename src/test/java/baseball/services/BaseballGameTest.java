package baseball.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import baseball.ConsoleView;
import baseball.domains.BaseballNumber;
import baseball.exceptions.BaseballNumberValidationException;

class BaseballGameTest {

	@DisplayName("BaseballNumberValidationException 이 발생하면 runWithErrorHandling의 결과는 true(재시도)")
	@Test
	void baseballNumberValidationExceptionIsTrueTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		BaseballGame baseballGame = new BaseballGame();
		Method runWithErrorHandling = baseballGame.getClass().getDeclaredMethod("runWithErrorHandling", Supplier.class);
		runWithErrorHandling.setAccessible(true);

		// when
		Object isRetry = runWithErrorHandling.invoke(baseballGame, (Supplier<Boolean>)() -> {
			throw new BaseballNumberValidationException("testException");
		});

		// then
		assertEquals(isRetry, true);
	}

	@DisplayName("Exception 이 발생하면 runWithErrorHandling의 결과는 false(재시도 X)")
	@Test
	void exceptionIsTrueTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		BaseballGame baseballGame = new BaseballGame();
		Method runWithErrorHandling = baseballGame.getClass().getDeclaredMethod("runWithErrorHandling", Supplier.class);
		runWithErrorHandling.setAccessible(true);

		// when
		Object isRetry = runWithErrorHandling.invoke(baseballGame, (Supplier<Boolean>)() -> {
			throw new RuntimeException("testException");
		});

		// then
		assertEquals(isRetry, false);
	}

	@DisplayName("사용자 입력이 정답일 경우 checkInputNumber()는 false(재시도 X) return")
	@Test
	void correctTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		BaseballGame baseballGame = new BaseballGame();
		BaseballNumber answerNumber = new BaseballNumber("123");

		try (final MockedStatic<ConsoleView> mockConsoleView = mockStatic(ConsoleView.class)) {
			mockConsoleView.when(ConsoleView::printInputNumber)
				.thenReturn("123");

			Method checkInputNumber = baseballGame.getClass()
				.getDeclaredMethod("checkInputNumber", BaseballNumber.class);
			checkInputNumber.setAccessible(true);

			// when
			Object isRetry = checkInputNumber.invoke(baseballGame, answerNumber);

			// then
			assertEquals(isRetry, false);
		}
	}

	@DisplayName("사용자 입력이 정답이 아닐 경우 checkInputNumber()는 true(재시도) return")
	@Test
	void wrongTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		BaseballGame baseballGame = new BaseballGame();
		BaseballNumber answerNumber = new BaseballNumber("123");

		try (final MockedStatic<ConsoleView> mockConsoleView = mockStatic(ConsoleView.class)) {
			mockConsoleView.when(ConsoleView::printInputNumber)
				.thenReturn("456");

			Method checkInputNumber = baseballGame.getClass()
				.getDeclaredMethod("checkInputNumber", BaseballNumber.class);
			checkInputNumber.setAccessible(true);

			// when
			Object isRetry = checkInputNumber.invoke(baseballGame, answerNumber);

			// then
			assertEquals(isRetry, true);
		}
	}
}