package player;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static player.Player.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PlayerTest {
	@Mock
	private Random random;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("플레이어 이름 앞뒤로 존재하는 공백문자는 제거되어야 한다")
	void whiteSpaceAtStartOrEndOfPlayerNameShouldBeRemoved() {
		// given

		// when
		Player player = new Player("   userTe st   ", 0);

		// then
		assertThat(player.getName()).isEqualTo("userTe st");
	}

	@Test
	@DisplayName("랜덤값이 경계값보다 작다면 전진할 수 없다")
	void playerShouldNotBeMovedIfRandomValueIsUnderBoundary() {
		// given
		given(random.nextInt(anyInt())).willReturn(BOUNDARY_FOR_MOVE - 1);
		Player player = new Player("user", 0);

		// when
		player.advance(random);

		// then
		assertThat(player.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("랜덤값이 경계값보다 크다면 전진할 수 있다")
	void playerCanMoveIfRandomValueIsGreaterThanBoundary() {
		// given
		given(random.nextInt(anyInt())).willReturn(BOUNDARY_FOR_MOVE);
		Player player = new Player("user", 0);

		// when
		player.advance(random);

		// then
		assertThat(player.getPosition()).isEqualTo(1);
	}
}
