package domain;

import java.util.Arrays;

public enum Function {
	REGISTRATION(1),
	PAYMENT(2),
	EXIT(3);

	private final int number;

	Function(int number) {
		this.number = number;
	}

	public static Function of(String number) {
		validate(number);
		return Arrays.stream(Function.values())
			.filter(value -> value.number == Integer.parseInt(number))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	private static void validate(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("기능은 1~3번밖에 존재하지 않습니다.");
		}
	}
}
