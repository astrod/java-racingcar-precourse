package player;

import java.util.Random;

public class Player {
	private static final int EXCLUSIVE_RANDOM_BOUNDARY = 9;
	protected static final int BOUNDARY_FOR_MOVE = 4;
	private static final int MAXIMUM_NAME_LENGTH = 5;

	private final String name;
	private int position;

	public Player(String name, int position) {
		String playerName = name.trim();
		if (playerName.length() > MAXIMUM_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차의 이름은 5글자 이내여야 합니다. input === " + playerName);
		}
		this.name = playerName;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void advance(Random random) {
		position += seeItMoveOrNot(random);
	}

	private int seeItMoveOrNot(Random random) {
		int randomValue = random.nextInt(EXCLUSIVE_RANDOM_BOUNDARY);
		if (randomValue < BOUNDARY_FOR_MOVE) {
			return 0;
		}

		return 1;
	}
}
