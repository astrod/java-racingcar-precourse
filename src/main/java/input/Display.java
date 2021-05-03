package input;

import java.util.Scanner;

import player.Player;
import player.PlayerGroup;
import player.Winner;

public class Display {
	private final Scanner scanner;

	public Display(Scanner scanner) {
		this.scanner = scanner;
	}

	public String acceptPlayers() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 분류");

		while (true) {
			try {
				return scanner.nextLine();
			} catch (Exception ex) {
				System.out.println("자동차 이름 입력을 실패했습니다. 다시 시도해 주세요");
			}
		}
	}

	public int acceptCount() {
		System.out.println("시도할 횟수는 몇회인가요?");

		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception ex) {
				System.out.println("횟수 입력을 실패했습니다. 다시 시도해 주세요");
			}
		}
	}

	public void showCarPosition(PlayerGroup playerGroup) {
		for (Player eachPlayer : playerGroup.getPlayers()) {
			System.out.println(eachPlayer.getName() + " : " + makeProgressBar(eachPlayer.getPosition()));
		}
		System.out.println();
	}

	private String makeProgressBar(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append("-");
		}

		return stringBuilder.toString();
	}

	public void showExecutionResult() {
		System.out.println("실행 결과");
	}

	public void showWinner(Winner winner) {
		System.out.println(winner.getWinnerName() + "가 최종 우승했습니다.");
	}
}
