import java.util.Random;
import java.util.Scanner;

import input.Display;
import player.PlayerGroup;
import racingtrack.RacingCount;
import racingtrack.RacingTrack;

public class RacingCarApplication {
	public static void main(String[] args) {
		try {
			Display display = new Display(new Scanner(System.in));

			PlayerGroup playerGroup = new PlayerGroup(display.acceptPlayers());
			RacingCount racingCount = new RacingCount(display.acceptCount());

			new RacingTrack(playerGroup, racingCount, display, new Random()).run();
		} catch (Exception ex) {
			System.out.println("자동차 경주 중 에러가 발생했습니다. message === " + ex.getMessage());
		}
	}
}
