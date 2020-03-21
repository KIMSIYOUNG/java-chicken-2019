package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuIdTest {
	@Test
	@DisplayName("생성이 정상적으로 이루어지는지 테스트합니다.")
	void ofTest() {
		assertThat(MenuId.of("1")).isInstanceOf(MenuId.class);
	}

	@Test
	@DisplayName("음수가 입력되는 경우 예외를 반환합니다.")
	void ofMinus() {
		assertThatThrownBy(() -> {
			MenuId.of("-1");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("존재하지 않는 아이디가 입력되는 경우 예외를 반환합니다.")
	void ofOverRange() {
		System.out.println(MenuId.of("12"));
	}

	@Test
	@DisplayName("정수가 입력되는 경우 예외를 반환합니다.")
	void ofString() {
		assertThatThrownBy(() -> {
			MenuId.of("일");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}