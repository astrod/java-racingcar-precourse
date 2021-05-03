package racingtrack;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCountTest {

	@Test
	@DisplayName("currentCount 를 goalCount 횟수만큼 증가시키면, isContinue 는 false 가 되어야 한다")
	void isContinueShouldBeFalseOnIncreasingCurrentCountByGoalCount() {
		// given
		int racingGoalCount = 5;

		// when
		RacingCount result = new RacingCount(racingGoalCount);
		for (int i = 0; i < racingGoalCount; i++) {
			result.increaseCurrentCount();
		}

		// then
		assertThat(result.isContinue()).isFalse();
	}
}
