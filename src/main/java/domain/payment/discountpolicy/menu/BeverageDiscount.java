package domain.payment.discountpolicy.menu;

import domain.Order;

public class BeverageDiscount implements DiscountPolicy {
	private static final double DISCOUNT_RATE = 0.5;
	private static final int DISCOUNT_DELIMITER = 3;
	private static final int BASIC_DISCOUNT_RATE = 0;

	@Override
	public int calculate(Order order) {
		if (order.getChickenCount() >= DISCOUNT_DELIMITER) {
			return (int)(order.getBeveragesPrice() * DISCOUNT_RATE);
		}
		return BASIC_DISCOUNT_RATE;
	}
}
