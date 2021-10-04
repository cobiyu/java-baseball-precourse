package baseball.domains;

import baseball.utils.Message;
import baseball.exceptions.BaseballNumberValidationException;

/**
 * @author cobiyu
 */
public class BaseballNumber {
  public static int NUMBER_MAX_LENGTH = 3;
  public static int INVALID_NUMBER = 0;

  private final String stringNumber;

  /**
   * constructor
   *
   * @param stringNumber 게임에 사용할 3자리의 1~9로만 이루어진 숫자
   * @throws BaseballNumberValidationException 숫자의 validation 체크 중 발생하는 예외
   */
  public BaseballNumber(String stringNumber) {
    validate(stringNumber);
    this.stringNumber = stringNumber;
  }

  /**
   * stringNumber getter
   * @return stringNumber
   */
  public String getStringNumber() {
    return stringNumber;
  }

  /**
   * validate
   * @param stringNumber validation 체크 할 string 형태의 숫자
   */
  private void validate(String stringNumber){
    if(!isNumber(stringNumber)){
      throw new BaseballNumberValidationException(Message.ONLY_NUMBER_PARAMETER);
    }
    if(isValidLength(stringNumber)){
      throw new BaseballNumberValidationException(Message.NOT_THREE_LENGTH_NUMBER);
    }
    if(!isPositiveNumber(stringNumber)){
      throw new BaseballNumberValidationException(Message.ONLY_POSITIVE_NUMBER);
    }
    if(isContainZero(stringNumber)){
      throw new BaseballNumberValidationException(Message.ONLY_ONE_TO_NINE);
    }
  }

  /**
   * 숫자인지 체크
   *
   * <pre>
   *   Integer.parseInt() 는 정수가 아닌 값이 파라미터로 넘어오면 Exception 발생
   *   위 현상을 이용해서 구현한 메소드
   * </pre>
   *
   * @param stringNumber string 형태의 숫자
   * @return 숫자 체크 결과
   */
  private boolean isNumber(String stringNumber){
    try {
      Integer.parseInt(stringNumber);
      return true;
    } catch(NumberFormatException e) {
      return false;
    }
  }

  /**
   * 유효한 숫자 길이인지 체크
   *
   * @param stringNumber string 형태의 숫자
   * @return 유효한 숫자 길이인지 체크 결과
   */
  private boolean isValidLength(String stringNumber){
    return stringNumber.length() != NUMBER_MAX_LENGTH;
  }

  /**
   * 양수 체크
   *
   * @param stringNumber string 형태의 숫자
   * @return 양수 체크 결과
   */
  private boolean isPositiveNumber(String stringNumber){
    int number = Integer.parseInt(stringNumber);

    return number > 0;
  }

  /**
   * 숫자에 0이 포함되어 있는지 체크
   *
   * @param stringNumber string 형태의 숫자
   * @return 숫자에 0이 포함되어 있는지 체크 결과
   */
  private boolean isContainZero(String stringNumber){
    return stringNumber.contains(String.valueOf(INVALID_NUMBER));
  }
}
