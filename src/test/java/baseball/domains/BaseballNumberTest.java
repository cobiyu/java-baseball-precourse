package baseball.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.exceptions.BaseballNumberValidationException;
import baseball.utils.Message;

class BaseballNumberTest {
  @DisplayName("유효한 BaseballNumber")
  @Test
  void validTest(){
    String number = "713";
    BaseballNumber baseballNumber = new BaseballNumber(number);

    assertEquals(baseballNumber.getStringNumber(), number);
  }

  @DisplayName("올바르지 않은 타입의 파라미터가 전달된다면 BaseballNumberValidationException 발생")
  @Test
  void typeValidationExceptionTest(){
    String number = "k8s";

    Exception exception = assertThrows(
      BaseballNumberValidationException.class,
      () -> new BaseballNumber(number)
    );
    
    assertTrue(exception.getMessage().contains(Message.ONLY_NUMBER_PARAMETER));
  }

  @DisplayName("길이 3자 이상의 파라미터가 전달된다면 BaseballNumberValidationException 발생")
  @Test
  void longLengthExceptionTest(){
    String number = "58102";

    Exception exception = assertThrows(
      BaseballNumberValidationException.class,
      () -> new BaseballNumber(number)
    );

    assertTrue(exception.getMessage().contains(Message.NOT_THREE_LENGTH_NUMBER));

  }

  @DisplayName("음수 파라미터가 전달된다면 BaseballNumberValidationException 발생")
  @Test
  void negativeNumberExceptionTest(){
    String number = "-28";

    Exception exception = assertThrows(
      BaseballNumberValidationException.class,
      () -> new BaseballNumber(number)
    );

    assertTrue(exception.getMessage().contains(Message.ONLY_POSITIVE_NUMBER));
  }

  @DisplayName("0 포함된 파라미터가 전달된다면 BaseballNumberValidationException 발생")
  @Test
  void containZeroExceptionTest(){
    String number = "109";

    Exception exception = assertThrows(
      BaseballNumberValidationException.class,
      () -> new BaseballNumber(number)
    );

    assertTrue(exception.getMessage().contains(Message.ONLY_ONE_TO_NINE));
  }
}
