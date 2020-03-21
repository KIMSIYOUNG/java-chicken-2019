package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
	private static final int TABLE_COUNT = 8;
	private static final List<Table> tables = new ArrayList<>();

	static {
		for (int i = 1; i <= TABLE_COUNT; i++) {
			tables.add(new Table(TableId.of(String.valueOf(i))));
		}
	}

	public static Table findById(String tableId) {
		return tables.stream()
			.filter(table -> table.isSameId(TableId.of(tableId)))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public static List<Table> getTables() {
		return Collections.unmodifiableList(tables);
	}
}
