package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest {
	@Test
	@DisplayName("정상적으로 주문이 입력된 경우 주문된 상태를 갖습니다.")
	void addTest() {
		Table table = new Table(TableId.of("1"));
		table.add(MenuRepository.findMenuById("1"), 10);
		assertThat(table.getOrder().isNotOrdered()).isFalse();
	}

	@Test
	@DisplayName("결제가 이루어진 경우 초기화가 제대로 되었는지 확인합니다.")
	void initTest() {
		Table table = new Table(TableId.of("1"));
		table.add(MenuRepository.findMenuById("1"), 10);
		table.init();
		assertThat(table.getOrder().isNotOrdered()).isTrue();
	}

	@Test
	@DisplayName("주문이 추가되지 않은 경우 isNotOrdered가 정상작동하는지 확인합니다.")
	void isNotOrderedTest() {
		Table table = new Table(TableId.of("1"));
		assertThat(table.isNotOrdered()).isTrue();
	}
}
