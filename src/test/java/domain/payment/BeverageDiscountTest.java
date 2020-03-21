package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;

class BeverageDiscountTest {
	@ParameterizedTest
	@ValueSource(ints = {5, 15, 20, 30})
	@DisplayName("음료할인이 정상적으로 수행되는지 테스트합니다.")
	void beverageTest(int count) {
		Order order = new Order();
		order.add(MenuRepository.findMenuById("1"), 3);
		Menu beverage = MenuRepository.findMenuById("10");
		order.add(beverage, count);
		int result = new BeverageDiscount().calculate(order);

		assertThat(result).isEqualTo((int)(beverage.getPrice() * 0.5) * count);
	}

	@ParameterizedTest
	@ValueSource(ints = {5, 15, 20, 30})
	@DisplayName("치킨을 3개 이하로 주문한 경우 할인이 적용되지 않습니다.")
	void beverageNotEnoughChickenTest(int count) {
		Order order = new Order();
		order.add(MenuRepository.findMenuById("1"), 2);
		Menu beverage = MenuRepository.findMenuById("10");
		order.add(beverage, count);
		int result = new BeverageDiscount().calculate(order);

		assertThat(result).isEqualTo(0);
	}
}