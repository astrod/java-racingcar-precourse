package racingtrack;

import java.util.Random;

import input.Display;
import player.PlayerGroup;

public class RacingTrack {
	private final PlayerGroup playerGroup;
	private final RacingCount racingCount;
	private final Display display;
	private final Random random;

	public RacingTrack(PlayerGroup playerGroup, RacingCount racingCount, Display display, Random random) {
		this.playerGroup = playerGroup;
		this.racingCount = racingCount;
		this.display = display;
		this.random = random;
	}

	public void run() {
		display.showExecutionResult();
		while (racingCount.isContinue()) {
			playerGroup.advance(random);
			display.showCarPosition(playerGroup);
			racingCount.increaseCurrentCount();
		}

		display.showWinner(playerGroup.generateWinner());
	}
}
