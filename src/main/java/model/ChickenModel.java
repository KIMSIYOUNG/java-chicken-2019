package model;

import java.io.IOException;
import java.util.List;

import domain.ChickenManager;
import domain.Menu;
import domain.Payment;
import domain.Table;
import view.InputView;
import view.OutputView;

public class ChickenModel {
    private static final int REGISTER = 1;
    private static final int PAY = 2;
    private static final int EXIT = 3;

    private List<Table> tables;
    private List<Menu> menus;
    private ChickenManager chickenManager;

    public ChickenModel(List<Table> tables, List<Menu> menus) {
        this.tables = tables;
        this.menus = menus;
        chickenManager = new ChickenManager(menus, tables);
    }

    public boolean startPos() throws IOException {
        int function;
        do {
            function = inputFunctionNumber();
            userWantToRegister(function);
            userWantToPay(function);
        } while (function != EXIT);
        return false;
    }

    private int inputFunctionNumber() throws IOException {
        OutputView.printMainFunctions();
        return InputView.inputFunctionNumber();
    }

    private void userWantToRegister(int function) throws IOException {
        if (function == REGISTER) {
            int tableNumber = inputTableNumber();
            int menuNumber = inputMenuNumber();
            int howMany = inputHowMany();
            setMenu(tableNumber, menuNumber, howMany);
        }
    }

    private int inputTableNumber() throws IOException {
        OutputView.printTables(tables);
        return InputView.inputTableNumber(tables);
    }

    private int inputHowMany() throws IOException {
        return InputView.inputHowMany();
    }

    private int inputMenuNumber() throws IOException {
        OutputView.printMenus(menus);
        return InputView.inputMenuNumber(menus);
    }

    private void setMenu(int tableNumber, int menuNumber, int howMany) {
        Table table = chickenManager.getTableByTableNumber(tableNumber);
        Menu menu = chickenManager.getMenuByMenuNumber(menuNumber);
        table.addMenu(table, menu, howMany);
    }

    private void userWantToPay(int function) throws IOException {
        if (function == PAY) {
            int tableNumber = inputTableNumber();
            Table table = chickenManager.getTableByTableNumber(tableNumber);
            checkNoMenuTable(table);
            startPayment(table);
        }
    }

    private boolean checkNoMenuTable(Table table) throws IOException {
        if(!table.hasMenu()){
            OutputView.printNoMenu();
            return startPos();
        }
        return true;
    }

    private void startPayment(Table table) throws IOException {
        OutputView.printTableBill(table);
        Payment payment = InputView.inputPayment();
        double totalMoney = table.getTotalMoneyWithPayment(payment);
        OutputView.printTotalMoney(totalMoney);
    }
}
