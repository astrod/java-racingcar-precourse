package racingtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import player.Player;

public class PlayerGroup {
	private static final String DELIMITER = ",";

	private final List<Player> players;
	private final Random random;

	public PlayerGroup(String players, Random random) {
		this.players = initializePlayers(players);
		this.random = random;
	}

	private List<Player> initializePlayers(String players) {
		if (players == null) {
			throw new IllegalArgumentException("플레이어 정보가 없습니다");
		}

		return makePlayers(Arrays.asList(players.split(DELIMITER)));
	}

	private List<Player> makePlayers(List<String> playerNames) {
		List<Player> result = new ArrayList<>();
		for (String eachName : playerNames) {
			result.add(new Player(eachName));
		}

		return result;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void advance() {
		for (Player eachPlayer : this.players) {
			eachPlayer.advance(random);
		}
	}
}
