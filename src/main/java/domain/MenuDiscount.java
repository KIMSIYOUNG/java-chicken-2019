package domain;

public class MenuDiscount implements DiscountPolicy {
	private static final int DISCOUNT_PRICE = 10000;
	private static final int UNIT = 10;

	@Override
	public int calculate(Order order) {
		return (order.getChickenCount() / UNIT) * DISCOUNT_PRICE;
	}
}
