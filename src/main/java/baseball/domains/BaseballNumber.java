package baseball.domains;

/**
 * Baseball 게임에 사용되는 숫자 정보
 * 
 * @author cobiyu 
 */
public class BaseballNumber {
  private final String stringNumber;

  /**
   * constructor 
   * @param stringNumber 문자 형태의 숫자
   */
  public BaseballNumber(String stringNumber) {
    this.stringNumber = stringNumber;
  }

  /**
   * stringNumber getter
   * @return stringNumber
   */
  public String getStringNumber() {
    return stringNumber;
  }
}
