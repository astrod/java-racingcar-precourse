package player;

import java.util.Random;

public class Player {
	private final String name;
	private int position;

	public Player(String name) {
		this.name = name.trim();
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void advance(Random random) {
		position++; // TODO 이 부분에 랜덤값을 활용하여 이동시키는 로직이 추가되어야 한다
	}
}
