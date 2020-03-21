package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FunctionTest {
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	@DisplayName("정상적인 입력의 경우 Function이 반환된다.")
	void ofTest(String input) {
		assertThat(Function.of(input)).isInstanceOf(Function.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "-1", "4"})
	@DisplayName("범위를 벗어난 경우 예외를 반환한다.")
	void ofOverRange(String input) {
		assertThatThrownBy(() -> {
			Function.of(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1e", "2b", "3a"})
	@DisplayName("정상적인 입력의 경우 Function이 반환된다.")
	void ofStringFormat(String input) {
		assertThatThrownBy(() -> {
			Function.of(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}