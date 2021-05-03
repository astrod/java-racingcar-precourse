package racingtrack;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void throwErrorIfPlayersIsNull() {
		// given

		// when

		// then
		assertThatIllegalArgumentException().isThrownBy(() -> new Player(null));
	}

	@Test
	void onlyOnePlayerShouldBeExistIfPlayerDontHaveComma() {
		// given

		// when
		Player result = new Player("testUser");

		// then
		assertThat(result.getPlayers()).containsExactly("testUser");
	}

	@Test
	void whiteSpaceAtStartOrEndOfPlayerNameShouldBeRemoved() {
		// given

		// when
		Player result = new Player("userTest  ,   userTest2");

		// then
		assertThat(result.getPlayers()).containsExactlyInAnyOrder("userTest", "userTest2");
	}
}
