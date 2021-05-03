package racingtrack;

public class RacingCount {
	private final int racingGoalCount;
	private int currentCount;

	public RacingCount(int racingGoalCount) {
		this.racingGoalCount = racingGoalCount;
		this.currentCount = 0;
	}

	public boolean isContinue() {
		return currentCount < racingGoalCount;
	}

	public void increaseCurrentCount() {
		this.currentCount++;
	}
}
