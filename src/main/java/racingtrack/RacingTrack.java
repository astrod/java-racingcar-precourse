package racingtrack;

import input.Display;

public class RacingTrack {
	private final PlayerGroup playerGroup;
	private final RacingCount racingCount;
	private final Display display;

	public RacingTrack(PlayerGroup playerGroup, RacingCount racingCount, Display display) {
		this.playerGroup = playerGroup;
		this.racingCount = racingCount;
		this.display = display;
	}

	public void run() {
		display.showExecutionResult();
		while (racingCount.isContinue()) {
			playerGroup.advance();
			display.showCarPosition(playerGroup);
			racingCount.increaseCurrentCount();
		}
	}
}
