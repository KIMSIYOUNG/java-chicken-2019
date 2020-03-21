package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTypeTest {
	@Test
	@DisplayName("생성된 인스턴스가 치킨인지를 판별해주는 메소드")
	void typeTest() {
		assertThat(MenuType.CHICKEN.isChicken()).isTrue();
	}

	@Test
	@DisplayName("생성된 인스턴스가 치킨이 아닌 경우 false를 리턴하는지")
	void beverageTest() {
		assertThat(MenuType.BEVERAGE.isChicken()).isFalse();
	}
}