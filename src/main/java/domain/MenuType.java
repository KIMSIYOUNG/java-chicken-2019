package domain;

public enum MenuType {
	CHICKEN("치킨"),
	BEVERAGE("음료");

	private final String menuType;

	MenuType(String menuType) {
		this.menuType = menuType;
	}

	public boolean isChicken() {
		return this == CHICKEN;
	}
}
