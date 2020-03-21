package domain;

import java.util.HashMap;
import java.util.Map;

public class TableId {
	public static final int TABLE_COUNT = 8;

	private static final Map<Integer, TableId> tableId = new HashMap<>();
	private final int id;

	static {
		for (int i = 1; i <= TABLE_COUNT; i++) {
			tableId.put(i, new TableId(String.valueOf(i)));
		}
	}

	private TableId(String id) {
		this.id = stringToInt(id);
	}

	public static TableId of(String id) {
		containKey(id);
		return tableId.get(stringToInt(id));
	}

	private static void containKey(String id) {
		if (tableId.containsKey(tableId.get(stringToInt(id)))) {
			throw new IllegalArgumentException("잘못된 아이디입니다.");
		}
	}

	private static int stringToInt(String id) {
		try {
			int parsedInt = Integer.parseInt(id);
			validate(parsedInt);
			return parsedInt;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format("%s 는 잘못된 값입니다", id));
		}
	}

	private static void validate(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("음수는 아이디로 사용할 수 없습니다.");
		}
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}