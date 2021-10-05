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
        // 스트라이크가 게임 숫자보다 적으면 FAIL
        if(strikeCount < numberLength ){
            return ResultType.FAIL;
        }

        return ResultType.SUCCESS;
    }

    /**
     * 게임 결과에 맞는 메시지 반환
     * @return 메시지
     */
    public String getStateMessage(){
        if(strikeCount + ballCount <= 0){
            return "낫싱";
        }

        return getStrikeMessage() + getBallMessage();
    }

    /**
     * 볼 count 관련 메시지
     */
    private String getBallMessage(){
        String message = "";
        if(strikeCount!=0 && ballCount!=0){
            message += " ";
        }

        if(ballCount > 0){
            message += ballCount + "볼";
        }

        return message;
    }

    /**
     * 스트라이크 count 관련 메시지
     */
    private String getStrikeMessage(){
        if(strikeCount > 0){
            return strikeCount + "스트라이크";
        }

        return "";
    }
}
