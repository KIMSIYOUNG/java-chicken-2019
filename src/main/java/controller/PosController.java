package controller;

import domain.Function;
import view.InputView;
import view.OutputView;

public class PosController {
	public void run() {
		OutputView.showFunctions();
		while (true) {
			Function.of(InputView.inputFunction()).run();
			OutputView.showFunctions();
		}
	}
}
