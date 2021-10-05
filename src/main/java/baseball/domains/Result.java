package baseball.domains;

/**
 * @author cobiyu
 */
public class Result {
    private final int numberLength;
    private final int strikeCount;
    private final int ballCount;

    /**
     * constructor
     *
     * @param gameNumberLength 게임 숫자 길이
     * @param strikeCount 스트라이크 count
     * @param ballCount 볼 count
     */
    public Result(int gameNumberLength, int strikeCount, int ballCount) {
        this.numberLength = gameNumberLength;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    /**
     * 게임 결과에 맞는 결과 종류 반환
     */
    public ResultType toResultType(){
        return null;
    }

    /**
     * 게임 결과에 맞는 메시지 반환
     * @return 메시지
     */
    public String getStateMessage(){
        return null;
    }
}
