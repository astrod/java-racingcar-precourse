package racingtrack;

import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import input.Display;
import player.PlayerGroup;

class RacingTrackTest {
	@Mock
	private PlayerGroup playerGroup;
	@Mock
	private Display display;
	@Mock
	private Random random;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("racingCount 의 isContinue 가 false 라면 즉시 run 을 중단한다")
	void runShouldBeFinishedIfIsContinueIsFalse() {
		// given
		RacingTrack racingTrack = new RacingTrack(playerGroup, new RacingCount(0), display, random);

		// when
		racingTrack.run();

		// then
		verify(playerGroup, times(0)).advance(random);
	}

	@Test
	@DisplayName("racingCount 의 현재 회차가 목표 회차에 도달했다면, run 을 중단한다")
	void runShouldBeFinishedOnChangingIsContinueForTrueToFalse() {
		// given
		RacingTrack racingTrack = new RacingTrack(playerGroup, new RacingCount(2), display, random);

		// when
		racingTrack.run();

		// then
		verify(playerGroup, times(2)).advance(random);
	}
}
