package player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayerGroup {
	private static final String DELIMITER = ",";

	private final List<Player> players;

	public PlayerGroup(String players) {
		this.players = initializePlayers(players);
	}

	private List<Player> initializePlayers(String players) { // TODO 이름은 다섯 글자 이하만 가능하다
		if (players == null) {
			throw new IllegalArgumentException("플레이어 정보가 없습니다");
		}

		return makePlayers(Arrays.asList(players.split(DELIMITER)));
	}

	private List<Player> makePlayers(List<String> playerNames) {
		List<Player> result = new ArrayList<>();
		for (String eachName : playerNames) {
			result.add(new Player(eachName, 0));
		}

		return result;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void advance(Random random) {
		for (Player eachPlayer : this.players) {
			eachPlayer.advance(random);
		}
	}

	public Winner generateWinner() {
		return new Winner(this.players);
	}
}
