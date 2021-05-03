package racingtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
	private final List<String> players;

	public Player(String players) {
		this.players = initializePlayers(players);
	}

	private List<String> initializePlayers(String players) {
		if (players == null) {
			throw new IllegalArgumentException("플레이어 정보가 없습니다");
		}

		return removeSpace(Arrays.asList(players.split(",")));
	}

	public List<String> getPlayers() {
		return players;
	}

	public List<String> removeSpace(List<String> playerToken) {
		List<String> result = new ArrayList<>();
		for (String eachPlayer : playerToken) {
			result.add(eachPlayer.trim());
		}

		return result;
	}

}
