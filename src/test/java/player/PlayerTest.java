package player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
	@Test
	@DisplayName("플레이어 이름 앞뒤로 존재하는 공백문자는 제거되어야 한다")
	void whiteSpaceAtStartOrEndOfPlayerNameShouldBeRemoved() {
		// given

		// when
		Player result = new Player("   userTe st   ");

		// then
		assertThat(result.getName()).isEqualTo("userTe st");
	}
}
