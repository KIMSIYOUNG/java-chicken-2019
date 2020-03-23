package domain;

import java.util.Arrays;

import service.PaymentService;
import service.PosService;
import service.ProgramExitService;
import service.RegistrationService;

public enum Function {
	REGISTRATION(1, new RegistrationService()),
	PAYMENT(2, new PaymentService()),
	EXIT(3, new ProgramExitService());

	private final int number;
	private final PosService posService;

	Function(int number, PosService posService) {
		this.number = number;
		this.posService = posService;
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

	public void run() {
		this.posService.run();
	}
}
