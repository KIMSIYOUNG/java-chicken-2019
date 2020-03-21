package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.MenuRepository;
import domain.Order;
import domain.payment.discountpolicy.menu.ChickenDiscount;

class ChickenDiscountTest {
	@ParameterizedTest
	@ValueSource(ints = {10, 15, 20})
	@DisplayName("10개이상의 치킨이 정상적으로 할인되는지 테스트")
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
	@DisplayName("10개미만의 치킨을 구매한 경우 할인 금액은 0원입니다.")
	void NotEnoughChickenDiscount(int count) {
		Order order = new Order();
		order.add(MenuRepository.findMenuById("1"), count);
		ChickenDiscount chickenDiscount = new ChickenDiscount();

		assertThat(chickenDiscount.calculate(order)).isEqualTo(0);
	}
}