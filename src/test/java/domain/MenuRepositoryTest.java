package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuRepositoryTest {
	@Test
	@DisplayName("생성된 전체 메뉴는 변경이 불가능하다.")
	void unmodifiableTest() {
		List<Menu> menus = MenuRepository.getMenus();
		assertThatThrownBy(() -> menus.remove(0))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("생성된 전체 메뉴는 추가가 불가능하다.")
	void unmodifiableAddTest() {
		List<Menu> menus = MenuRepository.getMenus();
		assertThatThrownBy(() -> menus.add(new Menu(MenuId.of("10"), "new Chicken", MenuType.CHICKEN, 10000)))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("11가지의 메뉴가 생성된다.")
	void sizeTest() {
		List<Menu> menus = MenuRepository.getMenus();
		assertThat(menus).hasSize(11);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "11"})
	@DisplayName("입력된 아이디에 대응되는 객체가 정상반환된다.")
	void findMenuByIdTest(String input) {
		Menu menuById = MenuRepository.findMenuById(input);
		assertThat(menuById).isInstanceOf(Menu.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"12", "13"})
	@DisplayName("범위를 초과하여 예외가 발생한다.")
	void findByIdOverRange(String input) {
		assertThatThrownBy(() -> {
			MenuRepository.findMenuById(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}