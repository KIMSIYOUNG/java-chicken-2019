package service;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class RegistrationService implements PosService {
	@Override
	public void run() {
		OutputView.showTables();
		Table table = TableRepository.findById(InputView.inputTableId());
		OutputView.printMenus(MenuRepository.getMenus());
		Menu menu = MenuRepository.findMenuById(InputView.inputMenuId());
		table.add(menu, InputView.inputMenuCount());
		OutputView.printSuccess();
	}
}
