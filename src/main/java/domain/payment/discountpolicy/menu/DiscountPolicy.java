package domain.payment.discountpolicy.menu;

import domain.Order;

public interface DiscountPolicy {
	int calculate(Order order);
}
