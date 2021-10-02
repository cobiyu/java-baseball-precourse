package baseball.exceptions;

/**
 * 게임에 사용되는 number validation 관련 Exception
 * 
 * @author cobiyu
 */
public class BaseballNumberValidationException extends RuntimeException {
  private final String message;

  public BaseballNumberValidationException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return "[ERROR] " + message;
  }
}
