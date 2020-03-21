package domain.payment;

import java.util.Arrays;

public enum PaymentType {
	CARD(1, new PaymentTypeGroup[] {PaymentTypeGroup.CARD}, 1),
	CASH(2, new PaymentTypeGroup[] {PaymentTypeGroup.CASH}, 0.95),
	COMMERCE_TYPE(3,
		new PaymentTypeGroup[] {PaymentTypeGroup.PAYCO, PaymentTypeGroup.KAKAO_PAY, PaymentTypeGroup.NAVER_PAY}, 0.9);

	private final int paymentType;
	private final PaymentTypeGroup[] paymentGroup;
	private final double discountRate;

	PaymentType(int paymentType, PaymentTypeGroup[] paymentGroup, double discountRate) {
		this.paymentType = paymentType;
		this.paymentGroup = paymentGroup;
		this.discountRate = discountRate;
	}

	public static PaymentType of(int paymentType) {
		return Arrays.stream(values()).filter(type -> type.paymentType == paymentType)
			.findAny()
			.orElseThrow(IllegalArgumentException::new);
	}

	public int calculate(int money) {
		return (int)(this.discountRate * money);
	}
}
