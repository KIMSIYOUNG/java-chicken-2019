package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
	@Test
	@DisplayName("정상적으로 메뉴추가가 되는지")
	void add() {
		Order order = new Order();
		Menu menuById = MenuRepository.findMenuById("1");
		order.add(menuById, 10);
		assertThat(order.getOrder().get(menuById)).isEqualTo(10);
	}

	@Test
	@DisplayName("99개 이상을 추가하는 경우 예외가 발생하는지")
	void addOverRange() {
		Order order = new Order();
		Menu menuById = MenuRepository.findMenuById("1");
		order.add(menuById, 50);

		assertThatThrownBy(() -> order.add(menuById, 50))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("하나의 메뉴는 99개만 주문할 수 있습니다.");
	}

	@Test
	@DisplayName("가격을 정상적으로 계산하는지")
	void calculateTest() {
		Order order = new Order();
		order.add(MenuRepository.findMenuById("1"), 10);
		order.add(MenuRepository.findMenuById("10"), 10);

		assertThat(order.calculatePrice()).isEqualTo(180000);
	}

	@Test
	@DisplayName("치킨 갯수를 정확하게 반환하는지 테스트합니다.")
	void getChickenCountTest() {
		Order order = new Order();
		Menu menuById = MenuRepository.findMenuById("1");
		Menu menu = MenuRepository.findMenuById("2");
		order.add(menuById, 50);
		order.add(menu, 30);
		assertThat(order.getChickenCount()).isEqualTo(80);
	}

	@Test
	@DisplayName("동일 제품을 두번 주문하는 경우를 테스트합니다.")
	void orderSameMenuOneMore() {
		Order order = new Order();
		order.add(MenuRepository.findMenuById("1"), 8);
		order.add(MenuRepository.findMenuById("1"), 2);
		assertThat(order.getChickenCount()).isEqualTo(10);
	}
}
