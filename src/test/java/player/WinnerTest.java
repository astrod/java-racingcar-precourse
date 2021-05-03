package player;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {

	@Test
	@DisplayName("우승자가 없는 경우엔 빈 공백문자를 반환한다")
	void returnEmptyStringIfThereIsNoWinner() {
		// given
		Winner winner = new Winner(null);

		// when
		String result = winner.getWinnerName();

		// then
		assertThat(result).isEqualTo("");
	}

	@Test
	@DisplayName("우승자의 이름이 한 가지인 경우 그 이름 한개만 가져온다")
	void getWinnerNameWithoutDelimiterIfWinnerIsOnlyOne() {
		// given
		List<Player> players = new ArrayList<>();
		addPlayer(players, "testUser", 2);
		addPlayer(players, "testUser2", 1);

		Winner winner = new Winner(players);

		// when
		String result = winner.getWinnerName();

		// then
		assertThat(result).isEqualTo("testUser");
	}

	@Test
	@DisplayName("우승자의 이름이 , 로 연결되어 노출되어야 한다. 마지막 우승자 뒤의 , 는 제거된 상태여야 한다")
	void getWinnerNameWithDelimiterIfWinnerIsSeveral() {
		// given
		List<Player> players = new ArrayList<>();
		addPlayer(players, "testUser", 1);
		addPlayer(players, "testUser2", 1);

		Winner winner = new Winner(players);

		// when
		String result = winner.getWinnerName();

		// then
		assertThat(result).isEqualTo("testUser, testUser2");
	}

	private void addPlayer(List<Player> players, String name, int position) {
		Player player = new Player(name, position);
		players.add(player);
	}
}
