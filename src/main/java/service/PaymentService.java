package service;

import domain.Table;
import domain.TableRepository;
import domain.payment.Payment;
import domain.payment.discountpolicy.menu.BeverageDiscount;
import domain.payment.discountpolicy.total.PaymentType;
import view.InputView;
import view.OutputView;

public class PaymentService implements PosService {
	@Override
	public void run() {
		OutputView.showTables();
		Table table = TableRepository.findById(InputView.inputTableId());
		OutputView.printOrder(table.getOrder());
		OutputView.printPayment(table);
		PaymentType paymentType = PaymentType.of(InputView.inputPaymentType());
		Payment payment = new Payment(table.getOrder(), new BeverageDiscount(), paymentType);
		OutputView.printTotalMoney(payment.calculate());

		table.init();
	}
}
