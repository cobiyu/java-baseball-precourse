package baseball.exceptions;

/**
 * 게임에 사용되는 number validation 관련 Exception
 *
 * @author cobiyu
 */
public class BaseballNumberValidationException extends RuntimeException {
	public BaseballNumberValidationException(String message) {
		super(message);
	}
}
