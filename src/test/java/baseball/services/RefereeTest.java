package baseball.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domains.BaseballNumber;
import baseball.domains.ResultState;

class RefereeTest {
  @DisplayName("3스트라이크 테스트")
  @Test
  public void threeStrikeTest(){
    BaseballNumber playNumber = new BaseballNumber("123");
    BaseballNumber answerNumber = new BaseballNumber("123");

    ResultState resultState = Referee.checkAnswerNumberAndPlayNumber(playNumber, answerNumber);

    assertEquals(resultState.getStateMessage(), "3스트라이크");
  }

  @DisplayName("낫싱 테스트")
  @Test
  public void nothingTest(){
    BaseballNumber playNumber = new BaseballNumber("123");
    BaseballNumber answerNumber = new BaseballNumber("456");

    ResultState resultState = Referee.checkAnswerNumberAndPlayNumber(playNumber, answerNumber);

    assertEquals(resultState.getStateMessage(), "낫싱");
  }

  @DisplayName("2볼 테스트")
  @Test
  public void twoBallTest(){
    BaseballNumber playNumber = new BaseballNumber("123");
    BaseballNumber answerNumber = new BaseballNumber("361");

    ResultState resultState = Referee.checkAnswerNumberAndPlayNumber(playNumber, answerNumber);

    assertEquals(resultState.getStateMessage(), "2볼");
  }

  @DisplayName("1스트라이크 테스트")
  @Test
  public void oneStrikeTest(){
    BaseballNumber playNumber = new BaseballNumber("123");
    BaseballNumber answerNumber = new BaseballNumber("573");

    ResultState resultState = Referee.checkAnswerNumberAndPlayNumber(playNumber, answerNumber);

    assertEquals(resultState.getStateMessage(), "1스트라이크");
  }
}
