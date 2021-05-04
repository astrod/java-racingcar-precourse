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
import player.PlayerGroup;
import player.Winner;

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
		assertThatIllegalArgumentException().isThrownBy(() -> new PlayerGroup(null));
	}

	@Test
	@DisplayName("입력값에 구분자가 없는 경우에는 오직 한 명의 플레이어만 생성되어야 한다")
	void onlyOnePlayerShouldBeExistIfPlayerDontHaveComma() {
		// given

		// when
		PlayerGroup result = new PlayerGroup("user");

		// then
		assertThat(result.getPlayers().get(0).getName()).isEqualTo("user");
		assertThat(result.getPlayers().size()).isEqualTo(1);
	}

	@Test
	@DisplayName("입력값에 구분자가 있는 경우에는 여러 명의 플레이어가 생성되어야 한다")
	void manyPlayerShouldBeExistIfPlayerNameHaveComma() {
		// given

		// when
		PlayerGroup result = new PlayerGroup("user,user2");

		// then
		assertThat(result.getPlayers().get(0).getName()).isEqualTo("user");
		assertThat(result.getPlayers().get(1).getName()).isEqualTo("user2");
		assertThat(result.getPlayers().size()).isEqualTo(2);
	}

	@Test
	@DisplayName("advance 호출시 각 player 는 advance 가 진행되어야 한다")
	void advanceShouldProgressOnCallingAdvance() {
		given(random.nextInt(anyInt())).willReturn(4);

		// given
		PlayerGroup playerGroup = new PlayerGroup("user,user2,user3");

		// when
		playerGroup.advance(random);

		// then
		for (Player eachPlayer : playerGroup.getPlayers()) {
			assertThat(eachPlayer.getPosition()).isEqualTo(1);
		}
	}

	@Test
	@DisplayName("winner 생성을 요청하면 우승자 데이터를 반환해야 한다")
	void generateWinner() {
		given(random.nextInt(anyInt())).willReturn(4);

		// given
		PlayerGroup playerGroup = new PlayerGroup("user,user2,user3");

		// when
		Winner winner = playerGroup.generateWinner();

		// then
		assertThat(winner.getWinnerName()).isEqualTo("user, user2, user3");
	}
}
