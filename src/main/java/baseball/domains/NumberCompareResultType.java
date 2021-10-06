package baseball.domains;

public enum NumberCompareResultType {
	STRIKE("스트라이크 "),
	BALL("볼"),
	NOTHING("낫싱");

	private final String name;

	/**
	 * constructor
	 * @param name 결과별 이름
	 */
	NumberCompareResultType(String name) {
		this.name = name;
	}

	/**
	 * getter
	 */
	public String getName() {
		return name;
	}
}
