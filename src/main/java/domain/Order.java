package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {
	public static final int MAX_MENU_COUNT = 99;
	public static final int INIT = 0;

	private final Map<Menu, Integer> order = new HashMap<>();

	public Order() {
		for (Menu menu : MenuRepository.getMenus()) {
			order.put(menu, INIT);
		}
	}

	public void initOrder() {
		order.keySet().stream()
			.forEach(key -> order.put(key, 0));
	}

	public void add(Menu menu, int count) {
		validateCount(menu, count);
		order.put(menu, order.get(menu) + count);
	}

	private void validateCount(Menu menu, int count) {
		if (order.get(menu) + count > MAX_MENU_COUNT)
			throw new IllegalArgumentException("하나의 메뉴는 99개만 주문할 수 있습니다.");
	}

	public Map<Menu, Integer> getOrder() {
		return Collections.unmodifiableMap(order);
	}

	public int calculatePrice() {
		return order.entrySet().stream()
			.mapToInt(items -> items.getKey().getPrice() * items.getValue())
			.sum();
	}

	public int getChickenCount() {
		return order.entrySet().stream()
			.map(Map.Entry::getKey)
			.filter(Menu::isChicken)
			.mapToInt(order::get)
			.sum();
	}

	public int getBeveragesPrice() {
		return order.entrySet().stream()
			.filter(entry -> !entry.getKey().isChicken())
			.mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
			.sum();
	}

	public boolean isNotOrdered() {
		return calculatePrice() == 0;
	}
}
