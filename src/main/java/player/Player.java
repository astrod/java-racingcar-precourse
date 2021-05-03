package player;

import java.util.Random;

public class Player {
	private static final int EXCLUSIVE_RANDOM_BOUNDARY = 9;
	protected static final int BOUNDARY_FOR_MOVE = 4;

	private final String name;
	private int position;

	public Player(String name, int position) {
		this.name = name.trim();
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
