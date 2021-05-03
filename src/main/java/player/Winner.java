package player;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class Winner {
	public static final String DELIMITER = ", ";
	private final List<Player> winner;

	public Winner(List<Player> players) {
		this.winner = calculateWinner(players);
	}

	private List<Player> calculateWinner(List<Player> players) {
		if (players == null || players.isEmpty()) {
			return Collections.emptyList();
		}

		int winnerPosition = retrieveWinnerPosition(players);
		players.removeIf(player -> player.getPosition() < winnerPosition);
		return players;
	}

	private int retrieveWinnerPosition(List<Player> players) {
		players.sort(Comparator.comparingInt(Player::getPosition).reversed());
		return players.get(0).getPosition();
	}

	public String getWinnerName() {
		StringJoiner stringJoiner = new StringJoiner(DELIMITER);
		for (Player eachPlayer : this.winner) {
			stringJoiner.add(eachPlayer.getName());
		}
		return stringJoiner.toString();
	}
}
