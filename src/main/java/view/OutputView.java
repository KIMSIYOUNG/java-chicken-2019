package view;

import java.util.List;

import domain.Menu;
import domain.Order;
import domain.Table;
import domain.TableRepository;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BOTTOM_LINE_WITH_ORDER = "└ ₩ ┘";

	public static void showTables() {
		List<Table> tables = TableRepository.getTables();
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printBottom(tables);
		System.out.println();
	}

	private static void printBottom(List<Table> tables) {
		for (Table table : tables) {
			if (table.isNotOrdered()) {
				System.out.print(BOTTOM_LINE);
				continue;
			}
			System.out.print(BOTTOM_LINE_WITH_ORDER);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void showFunctions() {
		System.out.println("##메인화면\n 1 - 주문등록 \n 2 - 결제하기 \n 3 - 프로그램 종료");
	}

	public static void printMenus(List<Menu> menus) {
		menus.forEach(System.out::println);
		System.out.println();
	}

	public static void printSuccess() {
		System.out.println("\n등록이 완료되었습니다. 맛있게 드시길");
	}

	public static void printOrder(Order order) {
		System.out.println("## 주문 내역");
		System.out.printf("%10s %10s %10s", "메뉴", "수량", "금액\n");
		order.getOrder().entrySet()
			.stream()
			.filter(entry -> entry.getValue() != 0)
			.forEach(item -> System.out.printf("%10s %10s %10s\n",
				item.getKey().getName(), item.getValue(), item.getKey().getPrice()));
	}

	public static void printPayment(Table table) {
		System.out.printf("\n## %s번 테이블의 결제를 진행합니다.\n", table.getId());
	}

	public static void printTotalMoney(int totalMoney) {
		System.out.println("\n##최종 결제 금액은");
		System.out.println(totalMoney + "입니다 \n");
	}
}
