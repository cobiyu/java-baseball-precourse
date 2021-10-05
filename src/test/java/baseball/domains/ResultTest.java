package baseball.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @DisplayName("3스트라이크 Result")
    @Test
    public void successTest(){
        //given
        int numberLength = 3;
        int strikeCount = 3;
        int ballCount = 0;

        // when
        Result result = new Result(numberLength, strikeCount, ballCount);

        // then
        assertEquals(result.toResultType(), ResultType.SUCCESS);
        assertEquals(result.getStateMessage(), "3스트라이크");
    }

    @DisplayName("3볼 Result")
    @Test
    public void threeBallTest(){
        //given
        int numberLength = 3;
        int strikeCount = 0;
        int ballCount = 3;

        // when
        Result result = new Result(numberLength, strikeCount, ballCount);

        // then
        assertEquals(result.toResultType(), ResultType.FAIL);
        assertEquals(result.getStateMessage(), "3볼");
    }

    @DisplayName("1스트라이크 2볼 Result")
    @Test
    public void oneStrikeTwoBallTest(){
        //given
        int numberLength = 3;
        int strikeCount = 1;
        int ballCount = 2;

        // when
        Result result = new Result(numberLength, strikeCount, ballCount);

        // then
        assertEquals(result.toResultType(), ResultType.FAIL);
        assertEquals(result.getStateMessage(), "1스트라이크 2볼");
    }

    @DisplayName("낫싱 Result")
    @Test
    public void nothingTest(){
        //given
        int numberLength = 3;
        int strikeCount = 0;
        int ballCount = 0;

        // when
        Result result = new Result(numberLength, strikeCount, ballCount);

        // then
        assertEquals(result.toResultType(), ResultType.FAIL);
        assertEquals(result.getStateMessage(), "낫싱");
    }
}