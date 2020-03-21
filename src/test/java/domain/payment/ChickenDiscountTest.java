package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.MenuRepository;
import domain.Order;

class ChickenDiscountTest {
	@ParameterizedTest
	@ValueSource(ints = {10, 15, 20})
	void chickenDiscountPolicy(int count) {
		Order order = new Order();
		order.add(MenuRepository.findMenuById("1"), count);
		order.add(MenuRepository.findMenuById("3"), count);
		ChickenDiscount chickenDiscount = new ChickenDiscount();

		assertThat(chickenDiscount.calculate(order))
			.isEqualTo(10000 * (order.getChickenCount() / 10));
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 5, 9})
	void NotEnoughChickenDiscount(int count) {
		Order order = new Order();
		order.add(MenuRepository.findMenuById("1"), count);
		ChickenDiscount chickenDiscount = new ChickenDiscount();

		assertThat(chickenDiscount.calculate(order)).isEqualTo(0);
	}
}