package domain;

public class Table {
	private final TableId id;
	private final Order order;

	public Table(TableId id) {
		this.id = id;
		this.order = new Order();
	}

	public boolean isSameId(TableId tableId) {
		return this.id.equals(tableId);
	}

	public void add(Menu menu, int count) {
		order.add(menu, count);
	}

	public void init() {
		order.initOrder();
	}

	public boolean isNotOrdered() {
		return order.isNotOrdered();
	}

	public Order getOrder() {
		return order;
	}

	public TableId getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
