package racingtrack;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import player.Player;

class PlayerGroupTest {
	@Mock
	private Random random;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Player 가 null 인 경우에는 에러를 반환해야 한다")
	void throwErrorIfPlayersIsNull() {
		// given

		// when

		// then
		assertThatIllegalArgumentException().isThrownBy(() -> new PlayerGroup(null, this.random));
	}

	@Test
	@DisplayName("입력값에 구분자가 없는 경우에는 오직 한 명의 플레이어만 생성되어야 한다")
	void onlyOnePlayerShouldBeExistIfPlayerDontHaveComma() {
		// given

		// when
		PlayerGroup result = new PlayerGroup("testUser", this.random);

		// then
		assertThat(result.getPlayers().get(0).getName()).isEqualTo("testUser");
		assertThat(result.getPlayers().size()).isEqualTo(1);
	}

	@Test
	@DisplayName("입력값에 구분자가 있는 경우에는 여러 명의 플레이어가 생성되어야 한다")
	void manyPlayerShouldBeExistIfPlayerNameHaveComma() {
		// given

		// when
		PlayerGroup result = new PlayerGroup("testUser,testUser2", this.random);

		// then
		assertThat(result.getPlayers().get(0).getName()).isEqualTo("testUser");
		assertThat(result.getPlayers().get(1).getName()).isEqualTo("testUser2");
		assertThat(result.getPlayers().size()).isEqualTo(2);
	}

	@Test
	@DisplayName("advance 호출시 각 player 는 advance 가 진행되어야 한다")
	void advanceShouldProgressOnCallingAdvance() {
		given(random.nextInt()).willReturn(1);

		// given
		PlayerGroup playerGroup = new PlayerGroup("testUser,testUser2,testUser3", this.random);

		// when
		playerGroup.advance();

		// then
		for (Player eachPlayer : playerGroup.getPlayers()) {
			assertThat(eachPlayer.getPosition()).isEqualTo(1);
		}
	}
}
