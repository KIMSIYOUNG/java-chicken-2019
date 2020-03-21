package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuId {
	public static final int MENU_COUNT = 11;

	private static final Map<Integer, MenuId> menuId = new HashMap<>();
	private final int id;

	static {
		for (int i = 1; i <= MENU_COUNT; i++) {
			menuId.put(i, new MenuId(String.valueOf(i)));
		}
	}

	private MenuId(String id) {
		this.id = stringToInt(id);
	}

	public static MenuId of(String id) {
		containKey(id);
		return menuId.get(stringToInt(id));
	}

	private static void containKey(String id) {
		if (menuId.containsKey(menuId.get(stringToInt(id)))) {
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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MenuId menuId = (MenuId)o;
		return id == menuId.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
