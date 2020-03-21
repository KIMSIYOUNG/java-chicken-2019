package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableRepositoryTest {
	@Test
	@DisplayName("테이블은 프로그램 시작시 8개로 초기화됩니다.")
	void sizeTest() {
		assertThat(TableRepository.getTables()).hasSize(8);
	}

	@Test
	@DisplayName("정상적으로 테이블을 찾는 경우")
	void findTest() {
		assertThat(TableRepository.findById("1")).isInstanceOf(Table.class);
	}

	@Test
	@DisplayName("정상적으로 테이블을 찾는 경우")
	void findOverRange() {
		assertThatThrownBy(() -> {
			TableRepository.findById("9");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("음수로 테이블을 찾는 경우 예외발생")
	void findMinusTable() {
		assertThatThrownBy(() -> {
			TableRepository.findById("-1");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("문자로 테이블을 찾는 경우")
	void findStringType() {
		assertThatThrownBy(() -> {
			TableRepository.findById("-1a");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
