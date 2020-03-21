package domain;

public class Menu {
	private final MenuId id;
	private final String name;
	private final MenuType menuType;
	private final int price;

	public Menu(MenuId id, String name, MenuType menuType, int price) {
		this.id = id;
		this.name = name;
		this.menuType = menuType;
		this.price = price;
	}

	public boolean isSameId(String menuId) {
		return this.id.equals(MenuId.of(menuId));
	}

	public int getPrice() {
		return price;
	}

	public boolean isChicken() {
		return this.menuType.isChicken();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[" + menuType + "] " + id + " - " + name + " : " + price + "원";
	}
}
