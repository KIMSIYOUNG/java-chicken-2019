package controller;

import domain.Function;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class PosController {
	public void run() {
		OutputView.showFunctions();
		Function function = Function.of(InputView.inputFunction());
		while (function != Function.EXIT) {
			OutputView.showTables();
			checkRegistration(function);
			checkPayment(function);
			OutputView.showFunctions();
			function = Function.of(InputView.inputFunction());
		}
	}

	private void checkRegistration(Function function) {
		if (function == Function.REGISTRATION) {
			register();
		}
	}

	private void register() {
		Table table = TableRepository.findById(InputView.inputTableId());
		OutputView.printMenus(MenuRepository.getMenus());
		Menu menu = MenuRepository.findMenuById(InputView.inputMenuId());
		table.add(menu, InputView.inputMenuCount());
		OutputView.printSuccess();
	}

	private void checkPayment(Function function) {
		if (function == Function.PAYMENT) {
			payment();
		}
	}

	private void payment() {

	}
}
