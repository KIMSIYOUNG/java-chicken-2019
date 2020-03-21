package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.MenuRepository;
import domain.Order;
import domain.payment.discountpolicy.menu.BeverageDiscount;
import domain.payment.discountpolicy.menu.ChickenDiscount;
import domain.payment.discountpolicy.total.PaymentType;

class PaymentTest {
	private final Order order = new Order();

	@BeforeEach
	void setUp() {
		order.add(MenuRepository.findMenuById("1"), 2);
		order.add(MenuRepository.findMenuById("10"), 20);
	}

	@Test
	@DisplayName("총금액 테스트 : Chicken, Card pay")
	void calculateTotalPay() {
		order.add(MenuRepository.findMenuById("1"), 8);
		Payment payment = new Payment(order, new ChickenDiscount(), PaymentType.CARD);
		assertThat(payment.calculate()).isEqualTo(190000);
	}

	@Test
	@DisplayName("총금액 테스트 : Chicken, Cash pay")
	void calculateCashAndChicken() {
		order.add(MenuRepository.findMenuById("1"), 8);
		Payment payment = new Payment(order, new ChickenDiscount(), PaymentType.CASH);
		assertThat(payment.calculate()).isEqualTo((int)(190000 * 0.95));
	}

	@Test
	@DisplayName("총금액 테스트 : Beverage, Card pay")
	void calculateCardAndBeverage() {
		order.add(MenuRepository.findMenuById("1"), 1);
		Payment payment = new Payment(order, new BeverageDiscount(), PaymentType.CARD);
		assertThat(payment.calculate()).isEqualTo(68000);
	}

	@Test
	@DisplayName("총금액 테스트 : Beverage, Card pay")
	void calculateCommerceAndBeverage() {
		order.add(MenuRepository.findMenuById("1"), 1);
		Payment payment = new Payment(order, new BeverageDiscount(), PaymentType.COMMERCE_TYPE);
		assertThat(payment.calculate()).isEqualTo((int)(68000 * 0.9));
	}
}