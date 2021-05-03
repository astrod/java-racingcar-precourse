package input;

import java.util.Scanner;

public class Display {
	private final Scanner scanner;

	public Display(Scanner scanner) {
		this.scanner = scanner;
	}

	public String acceptPlayers() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 분류");

		while (true) {
			try {
				return scanner.next();
			} catch (Exception ex) {
				System.out.println("자동차 이름 입력을 실패했습니다. 다시 시도해 주세요");
			}
		}
	}

	public int acceptCount() {
		System.out.println("시도할 횟수는 몇회인가요?");

		while (true) {
			try {
				return Integer.parseInt(scanner.next());
			} catch (Exception ex) {
				System.out.println("횟수 입력을 실패했습니다. 다시 시도해 주세요");
			}
		}
	}
}
