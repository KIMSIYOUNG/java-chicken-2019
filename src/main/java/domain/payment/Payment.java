package domain.payment;

import domain.Order;
import domain.payment.discountpolicy.menu.DiscountPolicy;
import domain.payment.discountpolicy.total.PaymentType;

public class Payment {
	private final Order order;
	private final DiscountPolicy discountPolicy;
	private final PaymentType paymentPolicy;

	public Payment(Order order, DiscountPolicy discountPolicy, PaymentType paymentPolicy) {
		this.order = order;
		this.discountPolicy = discountPolicy;
		this.paymentPolicy = paymentPolicy;
	}

	public int calculate() {
		int rawSum = order.calculatePrice();
		return paymentPolicy.calculate(rawSum - discountPolicy.calculate(order));
	}
}
