package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTypeTest {
	@Test
	@DisplayName("정상적으로 올바른 객체를 반환하는지 테스트합니다.")
	void ofTest() {
		assertThat(PaymentType.of(1)).isEqualTo(PaymentType.CARD);
		assertThat(PaymentType.of(2)).isEqualTo(PaymentType.CASH);
		assertThat(PaymentType.of(3)).isEqualTo(PaymentType.COMMERCE_TYPE);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 4, 7, 9})
	@DisplayName("잘못된 입력의 경우 예외를 반환합니다.")
	void ofIllegalArguments(int input) {
		assertThatThrownBy(() -> {
			PaymentType.of(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}