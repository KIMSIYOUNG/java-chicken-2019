package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {
	private static final List<Menu> menus = new ArrayList<>();

	static {
		menus.add(new Menu(MenuId.of("1"), "후라이드", MenuType.CHICKEN, 16000));
		menus.add(new Menu(MenuId.of("2"), "양념", MenuType.CHICKEN, 17000));
		menus.add(new Menu(MenuId.of("3"), "간장", MenuType.CHICKEN, 17000));
		menus.add(new Menu(MenuId.of("4"), "뿌링클", MenuType.CHICKEN, 18000));
		menus.add(new Menu(MenuId.of("5"), "볼케이노", MenuType.CHICKEN, 18500));
		menus.add(new Menu(MenuId.of("6"), "호식이두마리", MenuType.CHICKEN, 21000));
		menus.add(new Menu(MenuId.of("7"), "디디치킨", MenuType.CHICKEN, 20000));
		menus.add(new Menu(MenuId.of("8"), "카일치킨", MenuType.CHICKEN, 19500));
		menus.add(new Menu(MenuId.of("9"), "콜라", MenuType.BEVERAGE, 2000));
		menus.add(new Menu(MenuId.of("10"), "사이다", MenuType.BEVERAGE, 2000));
		menus.add(new Menu(MenuId.of("11"), "기네스", MenuType.BEVERAGE, 8000));
	}

	public static Menu findMenuById(String menuId) {
		return menus.stream()
			.filter(menu -> menu.isSameId(menuId))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public static List<Menu> getMenus() {
		return Collections.unmodifiableList(menus);
	}
}
